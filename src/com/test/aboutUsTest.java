package com.test;

import java.util.List;

import com.haikang.bean.aboutUs;
import com.haikang.dao.abuoutUsDao;

public class aboutUsTest {
    public static void main(String[] args) {    
        //abuoutUsDao.insertAboutUs(new aboutUs("a","b"));
        List<aboutUs> re = abuoutUsDao.getAboutUs();
        for (aboutUs ab : re){
            System.out.println("tittle:"+ab.getTitle());
            System.out.println("tittle:"+ab.getPic());
        }
        // aboutUs newab = new aboutUs("a","b");
        // abuoutUsDao.editAboutUs(newab, 3);
        // abuoutUsDao.delAboutUs(1);
    }
}
