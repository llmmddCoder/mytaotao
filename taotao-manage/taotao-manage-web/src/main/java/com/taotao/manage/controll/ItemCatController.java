package com.taotao.manage.controll;

import java.util.List;

import org.aspectj.internal.lang.annotation.ajcDeclareAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.taotao.manage.pojo.ItemCat;
import com.taotao.manage.service.ItemCatService;

@Controller
@RequestMapping("item/cat")
public class ItemCatController {
    @Autowired
    private ItemCatService itemCatService;
    
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<ItemCat>> queryItemCatListByParentId(@RequestParam(value = "id",defaultValue = "0")Long id){
        try {
            List<ItemCat> list = this.itemCatService.queryItemCatListByParentId(id);
            if(list == null || list.isEmpty()){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
            return ResponseEntity.ok(list);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }
}
