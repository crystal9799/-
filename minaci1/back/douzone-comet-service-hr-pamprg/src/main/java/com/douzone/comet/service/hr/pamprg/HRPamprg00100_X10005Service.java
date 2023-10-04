package com.douzone.comet.service.hr.pamprg;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.vfs2.util.DelegatingFileSystemOptionsBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StopWatch;

import com.douzone.comet.components.DzCometService;
import com.douzone.comet.service.hr.pamprg.dao.Pamprg00100_X10005Dao;
import com.douzone.comet.service.hr.pamprg.models.Pamprg00100_X10005Model;
import com.douzone.comet.service.util.StringUtil;
import com.douzone.comet.service.util.mybatis.MyBatisUtil;
import com.douzone.gpd.components.exception.DzApplicationRuntimeException;
import com.douzone.gpd.jdbc.core.MapperType;
import com.douzone.gpd.jdbc.objects.SqlPack;
import com.douzone.gpd.restful.annotation.DzApi;
import com.douzone.gpd.restful.annotation.DzApiService;
import com.douzone.gpd.restful.annotation.DzParam;
import com.douzone.gpd.restful.enums.CometModule;
import com.douzone.gpd.restful.enums.DzParamType;
import com.douzone.gpd.restful.enums.DzRequestMethod;
import com.douzone.gpd.restful.model.DzGridModel;
 

import utills.CommonUtil;

/**
 * @description : 승급관리기준표_Service
 * @Since : 23.09.12 화요일 개발시작
 * @Author : minaci
 * @History :
 */

@DzApiService(value = "HRPamprg00100_X10005Service", module = CometModule.HR, desc = "승급기준등록표_Service")
public class HRPamprg00100_X10005Service extends DzCometService {
 
	@Autowired
	Pamprg00100_X10005Dao pamprg00100_X10005Dao;

	// [메인화면 조회]
	@DzApi(url = "/list_HR_URGDBASETBL_INFO_X10005MST", desc = "승급기준표-조회", httpMethod = DzRequestMethod.GET)
	public List<Pamprg00100_X10005Model> list_HR_URGDBASETBL_INFO_X10005MST(
			@DzParam(key = "mpPROMO_YEAR_MONTH", desc = "승급년월", required = false, paramType = DzParamType.QueryString) String mpPROMO_YEAR_MONTH,
			@DzParam(key = "bizarea_cd", desc = "사업장", required = false, paramType = DzParamType.QueryString) String bizarea_cd
            )
			throws Exception {
		List<Pamprg00100_X10005Model> pamprg00100_X10005ModelList = new ArrayList<Pamprg00100_X10005Model>();

		try {
			HashMap<String, Object> parameters = new HashMap<String, Object>();

			parameters.put("P_COMPANY_CD", this.getCompanyCode());
			parameters.put("P_BIZAREA_CD", bizarea_cd);
			parameters.put("P_PROMO_YEAR_MONTH", mpPROMO_YEAR_MONTH);
//			parameters.put("P_PG_START", pagingStart);
//			parameters.put("P_PG_END", pagingCount);
			
//			if(pagingStart.equals("0")) {
//				parameters.put("P_PAGING_START", "0");
//				parameters.put("P_PAGING_COUNT", "99999999");
//			}
//			parameters.put("P_PAGING_START", pagingStart);
//			parameters.put("P_PAGING_COUNT", pagingCount);
			
			pamprg00100_X10005ModelList = pamprg00100_X10005Dao.selectPamprg00100_X10005ModelList(parameters);

			return pamprg00100_X10005ModelList;

		} catch (Exception e) {
			throw new DzApplicationRuntimeException(e);
		}

	}

	@DzApi(url = "/get_BizareaList", desc = "사업장 조회", httpMethod = DzRequestMethod.GET)
	public List<Pamprg00100_X10005Model> get_BizareaList() throws Exception {
		
		List<Pamprg00100_X10005Model> pamprg00100_X10005ModelList = new ArrayList<Pamprg00100_X10005Model>();
		
		try {
			
			HashMap<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("P_COMPANY_CD",this.getCompanyCode());
			
			pamprg00100_X10005ModelList = pamprg00100_X10005Dao.get_BizareaList(parameters);
		  
		} catch (DzApplicationRuntimeException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}

		return pamprg00100_X10005ModelList;
	}

	// [저장- delete/update/insert]
	@Transactional(rollbackFor = Exception.class)
	@DzApi(url = "/save_HR_URGDBASETBL_INFO_X10005MST", desc = "변경된 승급기준표 데이터소스 저장", httpMethod = DzRequestMethod.POST)
	public void save_HR_URGDBASETBL_INFO_X10005MST(
			@DzParam(key = "grid_ds", desc = "승급기준표 데이터", paramType = DzParamType.Body) DzGridModel<Pamprg00100_X10005Model> grid_ds)
			throws Exception {

		System.out.println("grid_ds" + grid_ds.getDeleted());
		try {
			String companyCd = this.getCompanyCode();
			String userId = this.getUserId();
			String userIp = this.getRemoteHost();
			
			CommonUtil commonUtil = new CommonUtil();

			// [delete]: 완료
			List<Pamprg00100_X10005Model> deletedRows = grid_ds.getDeleted();

			if (deletedRows != null && !deletedRows.isEmpty()) {
			    for (Pamprg00100_X10005Model deleteRow : deletedRows) {
			        commonUtil.setCommonFields(deleteRow, companyCd, userId, userIp);
			        deleteRow.setStd_ym(StringUtil.getLocaleTimeString(deleteRow.getStd_ym(), "yyyyMM"));
			    }
			    
			    pamprg00100_X10005Dao.deletePAMPRG00100_Model(deletedRows);
			    logger.info("그리드 삭제완료");
			}

			// [update]: 기본키 수정 가능하게 함(완료)
			List<Pamprg00100_X10005Model> updatedRows = grid_ds.getUpdated();
			if (updatedRows != null && !updatedRows.isEmpty()) {
			    for (Pamprg00100_X10005Model updateRow : updatedRows) {
			        commonUtil.setCommonFields(updateRow, companyCd, userId, userIp);
			        updateRow.setBwrk_my_calc_std_dt(
			                StringUtil.getLocaleTimeString(updateRow.getBwrk_my_calc_std_dt(), "yyyyMMdd"));
			        updateRow.setStd_ym(StringUtil.getLocaleTimeString(updateRow.getStd_ym(), "yyyyMM"));
			        logger.info("updateRow " + updateRow.toString());
			    }
			    pamprg00100_X10005Dao.updatePAMPRG00100_Model(updatedRows);
			    logger.info("그리드 수정완료");
			}

			// [insert]: 일괄 저장 merge into
			List<Pamprg00100_X10005Model> addedRows = grid_ds.getAdded();
			if (addedRows != null && !addedRows.isEmpty()) {
			    for (Pamprg00100_X10005Model insertRow : addedRows) {
			        commonUtil.setCommonFields(insertRow, companyCd, userId, userIp);
			        insertRow.setBwrk_my_calc_std_dt(
			                StringUtil.getLocaleTimeString(insertRow.getBwrk_my_calc_std_dt(), "yyyyMMdd"));
			        insertRow.setStd_ym(StringUtil.getLocaleTimeString(insertRow.getStd_ym(), "yyyyMM"));
			        logger.info("insertRow " + insertRow.toString());
			        try {
			            pamprg00100_X10005Dao.uploadPAMPRG00100_Model(insertRow);
			        } catch (Exception e) {
			            e.printStackTrace();
			        }
			        logger.info("그리드 추가완료");
			    }
			}
		} catch (Exception e) {
			throw new DzApplicationRuntimeException(e);
		}
	}

	// [종전자료 전 기존데이터 조회]
	@Transactional
	@DzApi(url = "/checkListExist", desc = "종전자료복사 전 기존데이터 조회", httpMethod = DzRequestMethod.GET)
	public boolean checkListExist(
			@DzParam(key = "targetYearMonth", desc = "승급년월", paramType = DzParamType.QueryString) String targetYearMonth,
			@DzParam(key = "bizarea_cd", desc = "사업장", paramType = DzParamType.QueryString) String bizarea_cd)
			throws Exception {

		try {

			HashMap<String, Object> parameters = new HashMap<String, Object>();

			parameters.put("P_COMPANY_CD", this.getCompanyCode());
			parameters.put("P_BIZAREA_CD", bizarea_cd);
			parameters.put("P_TARGET_YEAR_MONTH", targetYearMonth);

			int result = pamprg00100_X10005Dao.checkListExist(parameters);
			logger.info("result" + result);

			if (result > 0) {
				return false; // 있으면 false
			}
			return true;

		} catch (Exception e) {
			throw new DzApplicationRuntimeException(e);
		}

	}

	// [종전자료 전 기존데이터 삭제]
	@Transactional
	@DzApi(url = "/delete_BeforeList", desc = "종전자료복사 전 기존데이터 삭제", httpMethod = DzRequestMethod.GET)
	public boolean delete_BeforeList(
			@DzParam(key = "targetYearMonth", desc = "승급년월", paramType = DzParamType.QueryString) String targetYearMonth,
			@DzParam(key = "bizarea_cd", desc = "사업장", paramType = DzParamType.QueryString) String bizarea_cd)
			throws Exception {

		try {
			HashMap<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("P_COMPANY_CD", this.getCompanyCode()); // required
			parameters.put("P_TARGET_YEAR_MONTH", targetYearMonth);
			parameters.put("P_BIZAREA_CD", bizarea_cd);

			String sqlText = MyBatisUtil.getId(this.getClass(), "dao.Pamprg00100_X10005Dao.delete_BeforeList");
			SqlPack so = new SqlPack();
			so.setStoreProcedure(false);
			so.setMapperType(MapperType.MyBatis);
			so.setSqlText(sqlText);
			so.getInParameters().putAll(parameters);

			this.update(so);

		} catch (DzApplicationRuntimeException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}
		return true;
	}

	@Transactional
	@DzApi(url = "/copy_BeforeList", desc = "종전자료복사", httpMethod = DzRequestMethod.GET)
	public boolean copy_BeforeList(
			@DzParam(key = "mpPROMO_YEAR_MONTH", desc = "승급년월", paramType = DzParamType.QueryString) String mpPROMO_YEAR_MONTH,
			@DzParam(key = "targetYearMonth", desc = "승급년월", paramType = DzParamType.QueryString) String targetYearMonth,
			@DzParam(key = "bizarea_cd", desc = "사업장", paramType = DzParamType.QueryString) String bizarea_cd)
			throws Exception {

		try {
			HashMap<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("P_COMPANY_CD", this.getCompanyCode()); // required
			parameters.put("P_TARGET_YEAR_MONTH", targetYearMonth); // 대상년월
			parameters.put("P_PROMO_YEAR_MONTH", mpPROMO_YEAR_MONTH); // 승급년월
			parameters.put("P_BIZAREA_CD", bizarea_cd);
			parameters.put("P_BWRK_MY_CALC_STD_DT", targetYearMonth + "01"); // -- 산정기준일 (승급년월의 1일)

			parameters.put("P_INSERT_ID", this.getUserId()); // 등록ID
			parameters.put("P_INSERT_IP", this.getRemoteHost()); // 등록 IP

			String sqlText = MyBatisUtil.getId(this.getClass(), "dao.Pamprg00100_X10005Dao.copy_BeforeList");
			SqlPack so = new SqlPack();
			so.setStoreProcedure(false);
			so.setMapperType(MapperType.MyBatis);
			so.setSqlText(sqlText);
			so.getInParameters().putAll(parameters);

			this.update(so);

		} catch (DzApplicationRuntimeException e) {
			if (e.getCause().getMessage().contains("ORA-00001")) {
				throw new DzApplicationRuntimeException("현재 승급년월에 중복되는 데이터가 있습니다.");
			} else {
				throw e;
			}
		} catch (Exception e) {
			if (e.getCause().getMessage().contains("ORA-00001")) {
				throw new DzApplicationRuntimeException("현재 승급년월에 중복되는 데이터가 있습니다.");
			} else {
				throw e;
			}
		}

		return true;
	}

	@Transactional
	@DzApi(url = "/list_ym", desc = "년월조회", httpMethod = DzRequestMethod.GET)
	public List<Map<String, Object>> list_ym(
			@DzParam(key = "bizarea_cd", desc = "사업장", paramType = DzParamType.QueryString) String bizarea_cd)
			throws Exception {
		List<Map<String, Object>> list = new ArrayList<>();
		try {
			
			HashMap<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("P_COMPANY_CD", this.getCompanyCode());
			parameters.put("P_BIZAREA_CD", bizarea_cd);

			String sqlText = MyBatisUtil.getId(this.getClass(), "dao.Pamprg00100_X10005Dao.list_ym");
			SqlPack so = new SqlPack();
			so.setStoreProcedure(false);
			so.setMapperType(MapperType.MyBatis);
			so.setSqlText(sqlText);
			so.getInParameters().putAll(parameters);

			list = this.queryForList(so);
			System.out.println("list" + list.toString());

		} catch (DzApplicationRuntimeException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}
		return list;
	}

		@Transactional(rollbackFor = Exception.class)
		@DzApi(url = "/uploadExcel_HR_URGDBASETBL_INFO_X10005MST", desc = "엑셀업로드", httpMethod = DzRequestMethod.POST)
		public boolean pamodm01550x10005_excel_upload(
				@DzParam(key = "uploadData", desc = "업로드데이터", required = false, paramType = DzParamType.Body) List<Pamprg00100_X10005Model> uploadData,
				@DzParam(key = "bizarea_cd", desc = "사업장코드", required = false, paramType = DzParamType.Body) String bizarea_cd)
				throws Exception {

			// 변경된 객체와 그대로인 것의 객체 구별
			String companyCd = this.getCompanyCode();
			String userId = this.getUserId();
			String userIp = this.getRemoteHost();

			StopWatch stopWatch = new StopWatch();
			stopWatch.start();
			CommonUtil commonUtil = new CommonUtil();
			
			try {
				uploadData
					.parallelStream()
					.forEachOrdered(pamprg00100_X10005Model -> {
					try {
						pamprg00100_X10005Model = commonUtil.setCommonFields
								(pamprg00100_X10005Model, companyCd, userId, userIp);
						
						pamprg00100_X10005Model.setBizarea_cd(bizarea_cd);
						pamprg00100_X10005Model.setBwrk_my_calc_std_dt(StringUtil
								.getLocaleTimeString(pamprg00100_X10005Model.getBwrk_my_calc_std_dt(), "yyyyMMdd"));
						pamprg00100_X10005Model.setStd_ym(StringUtil.getLocaleTimeString(pamprg00100_X10005Model.getStd_ym(), "yyyyMM"));
						
						this.pamprg00100_X10005Dao.uploadPAMPRG00100_Model(pamprg00100_X10005Model);
						
					} catch (Exception e) {
						e.printStackTrace();  
					}
				});
			} catch (DzApplicationRuntimeException e) {
				throw e;
			} catch (Exception e) {
				throw e;
			} finally {
				stopWatch.stop();
				System.out.println(stopWatch.prettyPrint());
				System.out.println("코드 실행 시간 (s): " + stopWatch.getTotalTimeSeconds());
			}
			return true;
		}

}
