/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws.a.latihanujianjava;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author ASUS
 */
@Controller
@ResponseBody
public class BarangController {
    
    Barang data = new Barang();
    BarangJpaController actrl = new BarangJpaController();
    
    @RequestMapping("/getdatabrg")
    public List<Barang> getData(){
        
        return actrl.findBarangEntities();
    }
    
    @RequestMapping(value = "/getNamadata/{id}")
    public String getNama(@PathVariable("id") int id){
        try{
            data = actrl.findBarang(id);
            return data.getNama()+ "<br>" + data.getJumlah();
        }
        catch(Exception error){
            return "Data Barang Tidak Ditemukan";     
        }
    }
}
