package org.kand7dev.thymeleafproject.util;

public class PostUtility {

 public static String getUrl(String postTile){
  return postTile.trim().toLowerCase()
   .replaceAll("\\s+", "-")
   .replaceAll("[^A-Za-z0-9]", "-");
 }
}
