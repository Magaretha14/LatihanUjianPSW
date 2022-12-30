/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws.a.latihanujianjava;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ws.a.latihanujianjava.exceptions.NonexistentEntityException;

/**
 *
 * @author ASUS
 */
@Controller
@ResponseBody
public class javacontroller {
    A2020ws data = new A2020ws();
    A2020wsJpaController actrl = new A2020wsJpaController();
    private static Map<String, A2020ws> productRepo = new HashMap<>();
    
    @RequestMapping("/getdata")
    public List<A2020ws> getData(){
        
        return actrl.findA2020wsEntities();
    }
    
    @RequestMapping(value = "/data")
    public ResponseEntity<Object> getProduct(){
        return new ResponseEntity<>(productRepo.values(), HttpStatus.OK);
    }
    
    @RequestMapping("/getName/{id}")
    public String getName(@PathVariable("id") int id){
        try {
            data = actrl.findA2020ws(id);
            return data.getName() + "<br>" + data.getTglLahir();
        }
        catch (Exception error){
            
            return "Data tidak ada";
        }
        
    }
    //Delete ById
    @RequestMapping("/delete/{id}")
    public String deleteData(@PathVariable("id") int id){

            try{
                actrl.destroy(id);
                
                return id + " deleted";
            }
            catch(NonexistentEntityException error){
                return id + " tidak ada";
            }
    }
}
