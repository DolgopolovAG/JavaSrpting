package ru.gb;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ru.gb.config.HibernateConfig;
import ru.gb.dao.ManufacturerDao;
import ru.gb.dao.OldJdbcManufacturerDao;
import ru.gb.dao.product.OldJdbcProductDao;
import ru.gb.dao.product.ProductDao;
import ru.gb.entity.Manufacturer;
import ru.gb.entity.Product;

public class ShopApp {

    public static void main(String[] args) {
    //        OldJdbcManufacturerDao oldJdbcManufacturerDao = new OldJdbcManufacturerDao();
    //
    //
    //        for (Manufacturer manufacturer : oldJdbcManufacturerDao.findAll()) {
    //            System.out.println(manufacturer);
    //        }

//            AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(HibernateConfig.class);
//            ManufacturerDao manufacturerDao = context.getBean(ManufacturerDao.class);
//            System.out.println(manufacturerDao.findById(3L));
//            System.out.println(manufacturerDao.findNameById(5L));
    //        for (Manufacturer manufacturer : manufacturerDao.findAll()) {
    //            System.out.println(manufacturer);
    //        }

            //1
    //        OldJdbcProductDao oldJdbcProductDaoDao = new OldJdbcProductDao();
    //        for (Product pr : oldJdbcProductDaoDao.findAll()) {
    //            System.out.println(pr);
    //        }

            //2
//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DbConfig.class);
//        ProductDao productDao = context.getBean(ProductDao.class);
//        for (Product pr : productDao.findAll()) {
//            System.out.println(pr);
//        }

            //3
//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DbConfig.class);
//        ProductDao productDao = context.getBean(ProductDao.class);
//        System.out.println(productDao.findNameById(5L));

            //4
//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DbConfig.class);
//        ProductDao productDao = context.getBean(ProductDao.class);
//        System.out.println(productDao.findNameById(10L));
//        System.out.println(productDao.findById(3L));
//        for (Product pr : productDao.findAll()) {
//            System.out.println(pr);
//        }

            //5
         AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(HibernateConfig.class);
         ProductDao productDao = context.getBean(ProductDao.class);
         System.out.println(productDao.findNameById(10L));
         System.out.println(productDao.findById(3L));

    }
}
