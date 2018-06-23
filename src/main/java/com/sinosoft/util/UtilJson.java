package com.sinosoft.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class UtilJson {
	/**
	 * 将一般json字符串转化为map类型
	 * @param jsonString
	 * @return
	 */
    public static Map<String,String> getMap4Json(String jsonString){
        JSONObject jsonObject = JSONObject.fromObject( jsonString );  
        Iterator  keyIter = jsonObject.keys();
        String key=null;
        String value=null;
        Map<String,String> valueMap = new HashMap<String,String>();

        while( keyIter.hasNext()){
            key = (String)keyIter.next();
            value =(String)jsonObject.get(key);
            valueMap.put(key,value);
        }
        return valueMap;
    }
    
    /**
     * 将页面传进来的表格状态数据解析为List<Map<String,String>>类型，相当于对象列表
     * @param json
     * @return
     */
    public static List<Map<String,String>> getListMapObj(String json){
    	List<Map<String,String>> list= new ArrayList<Map<String,String>>();
		JSONArray jsonObj=JSONArray.fromObject(json);
		Object[] jsonArray=jsonObj.toArray();
		
		for (int i = 0; i < jsonArray.length; i++) {
			Map<String,String> map=new HashMap<String, String>();
			String key=null;
			String value=null;
			JSONObject jsonO=JSONObject.fromObject(jsonArray[i]);
			Iterator<String> keyIter=jsonO.keys();
			while(keyIter.hasNext()){
				key=(String)keyIter.next();
				value=(String)jsonO.getString(key);
				map.put(key, value);
			}
			list.add(map);
		}
		if(list.isEmpty()){
			return null;
		}
		return list;
    }
    /**
     * 将一般json字符串转化为数组类型
     * @param jsonString
     * @return
     */
    public static Object[] getObjectArray4Json(String jsonString){
        JSONArray jsonArray = JSONArray.fromObject(jsonString);
        return jsonArray.toArray();
        
    }
    public static void main(String[] args) {
		Object[] a=getObjectArray4Json("['dddd','asdf','afdf']");
		for (int i = 0; i < a.length; i++) {
			System.out.println((String)a[i]);
		}
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", "123");
		map.put("name", "lflei");
		map.put("lastName", "last");
		JSONObject json=JSONObject.fromObject(map);
		System.out.println(json);
	}
    
    public static void printMapJson(HttpServletResponse response,Map<String,? extends Object> map){
    	JSONObject json=JSONObject.fromObject(map);
		System.out.println("************************************************");
		System.out.println(json);
		System.out.println("************************************************");
    	
    	PrintWriter pw=null;
    	try {
    		pw = response.getWriter();
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    	pw.print(json);
    }
    
    public static void printListJson(HttpServletResponse response,List<? extends Object> list){
		JSONArray json=JSONArray.fromObject(list);
		System.out.println("************************************************");
		System.out.println(json);
		System.out.println("************************************************");
		PrintWriter pw=null;
		try {
			pw=response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		pw.print(json);
    }
    
    public static void print(HttpServletResponse response,Object obj){
		System.out.println("************************************************");
		System.out.println(obj);
		System.out.println("************************************************");
		PrintWriter pw=null;
		try {
			pw=response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		pw.print(obj);
    }
    public static List<Map<String,String>> jsonDoc(String json){
    	
    	List<Map<String,String>> list=new ArrayList<Map<String,String>>();
    	
    	JSONArray jsonObj=JSONArray.fromObject(json);
    	Object[] jsonArray=jsonObj.toArray();

    	for (int i = 0; i < jsonArray.length; i++) {
    		
    		Map<String,String> map=new HashMap<String, String>();
    		String key=null;
    		String value=null;
    		JSONObject jsonO=JSONObject.fromObject(jsonArray[i]);
    		Iterator<String> keyIter=jsonO.keys();
    		while(keyIter.hasNext()){
    			key=(String)keyIter.next();
    			value=(String)jsonO.getString(key);
    			map.put(key, value);
    		}
    		
    		list.add(map);
    	
    }
    	return list;
    }
public static List<Map<String,String>> jsonDocOne(String json){
    	
    	List<Map<String,String>> list=new ArrayList<Map<String,String>>();
    	
    	JSONArray jsonObj=JSONArray.fromObject(json);
    	Object[] jsonArray=jsonObj.toArray();

    	for (int i = 0; i < jsonArray.length; i++) {
    		//[{corpflow_bank_id:32606,state:1}]
    		Map<String,String> map=new HashMap<String, String>();
    		String key=null;
    		String value=null;
    		String key1=null;
    		String value1=null;
    		JSONObject jsonO=JSONObject.fromObject(jsonArray[i]);
    		Iterator<String> keyIter=jsonO.keys();
    		while(keyIter.hasNext()){
//    			key="corpflow_bank_id";
    			key=(String)keyIter.next();
//    			key1="status";
    		   value=(String)jsonO.getString(key);
    			map.put(key,value);
//    			map.put(key1,value1);
    			
    		
    		}
    		
    		list.add(map);
    	
    }
    	return list;
    }
}
