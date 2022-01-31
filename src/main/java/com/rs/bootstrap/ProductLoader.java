package com.rs.bootstrap;

import com.rs.domain.Product;
import com.rs.repositories.ProductRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * created by rs 1/30/2022.
 */
@Component
public class ProductLoader implements ApplicationListener<ContextRefreshedEvent> {

    private ProductRepository productRepository;

    private Logger log= LogManager.getLogger(ProductLoader.class);

    @Autowired
    public ProductLoader(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        Product shirt = new Product();
        shirt.setDescription("Arrow Shirt");
        shirt.setPrice(new BigDecimal("22.99"));
        shirt.setImageUrl("https://media.kohlsimg.com/is/image/kohls/3218798_Viola?wid=1200&hei=1200&op_sharpen=1");
        shirt.setProductId("235268845711068308");
        productRepository.save(shirt);

        log.info("Saved Shirt - id: " + shirt.getId());

        Product mug = new Product();
        mug.setDescription("Spring Framework Guru Mug");
        mug.setImageUrl("https://images2.teeshirtpalace.com/images/productImages/bcc8544660-bearded-computer-coder--white-cfm-front.jpg?width=767");
        mug.setProductId("168639393495335947");
        mug.setPrice(new BigDecimal("11.95"));
        productRepository.save(mug);

        log.info("Saved Mug - id:" + mug.getId());
    }
}
