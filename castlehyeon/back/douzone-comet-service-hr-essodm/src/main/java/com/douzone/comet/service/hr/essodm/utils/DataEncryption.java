package com.douzone.comet.service.hr.essodm.utils;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import com.douzone.comet.components.DzCometService;
import com.douzone.comet.cryptography.enums.EncryptStyle;
import com.douzone.comet.service.util.BlackBoxUtil;
import com.douzone.comet.service.util.api.models.EncParameter;
import com.douzone.gpd.restful.model.DzGridModel;

public class DataEncryption extends DzCometService{

	public String incode(String res_no){
		BlackBoxUtil bbu = null;
		try {
			bbu = new BlackBoxUtil(this.getUserId(), this.getCompanyCode(), this.getGroupCode());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
		//암호화 처리 added ------------------------- start
//		String strTrgtp_res_no = addedData.getTrgtp_res_no();
		String strTrgtp_res_no = res_no;                  
		try {
			strTrgtp_res_no = bbu.addwithKey(strTrgtp_res_no.toString().replace("-", ""), EncryptStyle.JUMIN);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return strTrgtp_res_no;
	}
	
	public List<?> decode(List<?> items, Class<?> clazz) {
//    System.out.println("암호화=======================================");
//    items.toString();
//    System.out.println("암호화=======================================");
    BlackBoxUtil BB = null;
    List<?> decodedList = new ArrayList<>(); // 초기화

    try {
        BB = new BlackBoxUtil(this.getUserId(), this.getCompanyCode(), this.getGroupCode());
    } catch (Exception e) {
        e.printStackTrace();
    }

    List<EncParameter> encParameters = new ArrayList<>();
    EncParameter encParameter = new EncParameter();
    encParameter.setKeyField("res_no");
    encParameter.setValueField("res_no");
    encParameter.setTargetField("res_no");
    encParameter.setEncryptStyle(EncryptStyle.JUMIN);
    encParameters.add(encParameter);

    try {
        // 기존 decode 메서드 호출 삭제
        
        // 나머지 암호화 처리 코드 작성
        decodedList = BB.getDecryptTextList(items, encParameters);

    } catch (Exception e) {
        e.printStackTrace();
    }
    System.out.println("암호화=======================================");
    System.out.println("decodedList ===>" + decodedList.toString());
    System.out.println("암호화=======================================");
    return decodedList;
}
	
	public String decode(String encodeData) {
	    BlackBoxUtil BB = null;

	    try {
	        BB = new BlackBoxUtil(this.getUserId(), this.getCompanyCode(), this.getGroupCode());
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    
	    String decodeData = null;
		try {
			decodeData = BB.getDecryptText(encodeData, EncryptStyle.JUMIN);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    return decodeData;
	}
}
