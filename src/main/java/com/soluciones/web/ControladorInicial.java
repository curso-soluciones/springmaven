/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.soluciones.web;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author campitos
 */
@Controller
@RequestMapping("/hola")
public class ControladorInicial {
    ArrayList<Usuario> usuarios;
    
    @RequestMapping(value="/mensaje", method=RequestMethod.GET, headers = {"Accept=text/html"})
    @ResponseBody String hola(){
        return "Hola mundo";
    }
    /* Metodo get para todos */
    @RequestMapping(value="/json", method=RequestMethod.GET, headers = {"Accept=Application/json"})
    public @ResponseBody String hola2()throws Exception{
        usuarios=obtenerBasesita();
       
        Map<String, ArrayList<Usuario>> singletonMap=Collections.singletonMap("usuarios",usuarios);
		ObjectMapper mapper=new ObjectMapper();
		return mapper.writeValueAsString(singletonMap);
        
        
    }
    
    /* metodo GET PARA BUSCAR POR UNO SOLO */
    @RequestMapping(value="/json/{nombre}", method=RequestMethod.GET, headers={"Accept=Application/json"})
    public @ResponseBody String obtenerUnUsuario(@PathVariable String nombre)throws Exception{
 
     
     Map<String,String> map = new HashMap<String,String>();
	ObjectMapper mapper = new ObjectMapper();   
 
	
 
            // int edad=Integer.parseInt(map.get("edad"));
             System.out.println("Vas a obtenger (get) al id:"+nombre);
               usuarios=obtenerBasesita();
       Usuario usuario=new Usuario(3,"juan carlitos  preciosote",41);
        Map<String, Usuario> singletonMap=Collections.singletonMap("usuarios",usuario);
		ObjectMapper mapper2=new ObjectMapper();
		return mapper2.writeValueAsString(singletonMap);
            
             
 
    }
    
    /*Metodo post para guardar un usuario con todos sus campos*/
    @RequestMapping(value="/json", method=RequestMethod.POST, headers={"Accept=Application/json"})
    public @ResponseBody String guardarUsuario(@RequestBody String json){
     System.out.println("Hola putotes de a baro"+json);
     
     Map<String,String> map = new HashMap<String,String>();
	ObjectMapper mapper = new ObjectMapper();
 
	try {
 
		//convert JSON string to Map
		map = mapper.readValue(json, 
		    new TypeReference<HashMap<String,String>>(){});
 
		System.out.println(map);
             String nombre= map.get("nombre");
            // int edad=Integer.parseInt(map.get("edad"));
             System.out.println("Este es tu nombre putarlosaurio:"+nombre );
 
	} catch (Exception e) {
		e.printStackTrace();
	}
     
     
     return json;
    }
    /* el put se usa para actualizar, cuando pones un id es que vas  a actualizar, si quieres buscar el  el metodo get
    y se usa  en sencha touch el mismo save pero sin id
    */
    @RequestMapping(value="/json/{id}", method=RequestMethod.PUT, headers={"Accept=Application/json"})
    public @ResponseBody String guardarUsuario2(@PathVariable int id,@RequestBody String json){
     System.out.println("Hola putotes de a baro"+json);
     
     Map<String,String> map = new HashMap<String,String>();
	ObjectMapper mapper = new ObjectMapper();
 
	try {
 
		//convert JSON string to Map
		map = mapper.readValue(json, 
		    new TypeReference<HashMap<String,String>>(){});
 
		System.out.println(map);
             String nombre= map.get("nombre");
            // int edad=Integer.parseInt(map.get("edad"));
             System.out.println("Vas a actualziar tu meirda nombre:"+nombre );
 
	} catch (Exception e) {
           
		e.printStackTrace();
	}
     
     
     return json;
    }
    
    ArrayList<Usuario> obtenerBasesita(){
       usuarios=new ArrayList<Usuario>();
         Usuario u1=new Usuario(4,"Juan",41);
        Usuario u2=new Usuario(2,"Ana",57);
        Usuario u3=new Usuario(3,"Chana",77);
        usuarios.add(u1);
        usuarios.add(u2);
        usuarios.add(u3);
        return usuarios;
    }
}
