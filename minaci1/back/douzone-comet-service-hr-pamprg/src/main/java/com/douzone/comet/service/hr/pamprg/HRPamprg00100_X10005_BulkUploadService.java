package com.douzone.comet.service.hr.pamprg;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.douzone.comet.components.DzCometService;
import com.douzone.comet.service.hr.pamprg.dao.Pamprg00100_X10005Dao;
import com.douzone.comet.service.hr.pamprg.models.Pamprg00100_X10005Model;
import com.douzone.gpd.restful.annotation.DzApi;
import com.douzone.gpd.restful.annotation.DzApiService;
import com.douzone.gpd.restful.annotation.DzParam;
import com.douzone.gpd.restful.enums.CometModule;
import com.douzone.gpd.restful.enums.DzParamType;
import com.douzone.gpd.restful.enums.DzRequestMethod;
 

/**
 * @description : 대용량엑셀업로드_Service
 * @Since : 23.09.24 일요일 개발시작
 * @Author : minaci
 * @History :
 */
@ResponseBody
@DzApiService(value = "HRPamprg00100_X10005_BulkUploadService", module = CometModule.HR, desc = "대용량엑셀업로드_Service")
public class HRPamprg00100_X10005_BulkUploadService extends DzCometService {

    @Autowired
    Pamprg00100_X10005Dao pamprg00100_X10005Dao;

    @DzApi(url = "/uploadFile_HR_URGDBASETBL_INFO_X10005MST", desc = "대용량엑셀업로드", httpMethod = DzRequestMethod.POST)
    public List<Pamprg00100_X10005Model> uploadFile_HR_URGDBASETBL_INFO_X10005MST(
            @DzParam(key = "file", desc = "엑셀업로드데이터", required = false, paramType = DzParamType.File) MultipartFile file
    ) throws Exception {
    	
    	System.out.println("file " + file);
        List<Pamprg00100_X10005Model> pamprg00100_X10005ModelList = new ArrayList<Pamprg00100_X10005Model>();

        try {
            if (!file.isEmpty()) {
                // 파일이 비어 있지 않으면 처리
                InputStream inputStream = file.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                String line;
                while ((line = reader.readLine()) != null) {
                    // 파일 내용을 처리하는 로직을 작성합니다.
                    System.out.println(line);
                }
                reader.close();
                inputStream.close();
                
                // 파일 처리가 완료되면 원하는 결과를 반환합니다.
                // 예를 들어, 업로드된 파일의 내용을 파싱하여 모델 리스트를 생성하고 반환할 수 있습니다.
                // pamprg00100_X10005ModelList = processFile(file);
                
                System.out.println("파일 업로드 및 처리 성공");
            }
        } catch (Exception e) {
            System.out.println("파일 업로드 및 처리 실패: " + e.getMessage());
        }

        return pamprg00100_X10005ModelList;
    }
}

//한번에 엑셀 올리는게 있다 . 데이터 많을 수 있따. 보내고 받고 %(몇퍼센트) 로 정해서 전체 사용 . 몇만개 넣어도 상관 없다 .
//

  
 
  