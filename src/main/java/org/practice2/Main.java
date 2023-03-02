package org.practice2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public int age;

    public static void main(String[] args) throws Exception {
        Template temp = new Template("Hello, ${name}! You are learning ${lang}!");
        // method 1
//        Map<String,String> map = new HashMap<>();
//        map.put("name","Emma");
//        map.put("lang","Java");
        // method 2
        Map<String, String> map = Map.of("name", "Emma", "lang", "Java");
        System.out.println(temp.render(map));
    }
}

// 编写一个简单的模板引擎
class Template {

    final String template;
    final Pattern pattern = Pattern.compile("\\$\\{(\\w+)\\}");

    public Template(String template) {
        this.template = template;
    }

    public String render(Map<String, String> data) {
        Matcher m = pattern.matcher(template);
        StringBuilder sb = new StringBuilder();
        while (m.find()) {
            m.appendReplacement(sb, data.get(m.group(1)).toString());
        }
        m.appendTail(sb);
        return sb.toString();
    }

}








