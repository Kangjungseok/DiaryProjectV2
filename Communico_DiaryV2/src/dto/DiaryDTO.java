package dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;


@Data
public class DiaryDTO extends DTO{
	
	String email;
	String spaceCode;
	int taskIndex;
	String task;
	String manager;
	Date dDay;
	
	
	
	String pk1 = "spaceCode";
	String pk2 = "taskIndex";
		
	
	
	
	public DiaryDTO(String spaceCode, int taskIndex) {
		super();
		this.spaceCode = spaceCode;
		this.taskIndex = taskIndex;
	}
	
	public String getAllValues() {
		String emailSql = "\'"+ this.email +"\'";
		String spaceCodeSql = "\'"+ this.spaceCode +"\'";
		String taskIndexSql = "\'" + this.taskIndex + "\'";
		String taskSql = "\'"+ this.task +"\'";
		String managerSql = "\'"+ this.manager +"\'";
		//String dDaySql = "\'"+ dDay +"\'";
		
		String sql = emailSql+", "+ spaceCodeSql + ", " + taskIndexSql + ", " + 
				taskSql + ", " + managerSql;
		
		if(this.dDay != null) {
			sql += ", \'" + this.dDay + "\'"; 
		}else {
			sql += ", null";
		}
		return sql;
	}

	@Override
	public String getPKNames() {

		String pkNames = pk1 + ", " + pk2;
		return pkNames;
	}
	
	@Override
	public String getPKValues() {
		String pkValues = this.getSpaceCode() + ", " + this.getTaskIndex();
		return pkValues;
	}
	
	public String getPk1() {
		String pk1 = this.spaceCode;
		return pk1;
	}
	public String getPk2Name() {
		String pk2 = this.pk2;
		return pk2;
	}

	@Override
	public String searchByPk() {
		// WHERE 절 뒤에 올 문장.
		String condition = pk1 + " = '" + this.spaceCode + "' AND " + pk2 + " = '" + this.taskIndex + "'";
		return condition;
	}

	@Override
	public String updateSql() {
		// UPDATE 테이블명 SET 다음 올 부분.
		String emailSql = "\'"+ this.email +"\'";
		String spaceCodeSql = "\'"+ this.spaceCode +"\'";
		String taskIndexSql = "\'" + this.taskIndex + "\'";
		String taskSql = "\'"+ this.task +"\'";
		String managerSql = "\'"+ this.manager +"\'";
		String updateSql = "email = " + emailSql + ", spaceCode = " + spaceCodeSql +
					", taskIndex = " + taskIndexSql + ", task = " + taskSql +
					", manager = " + managerSql ;
		
		if (this.dDay != null) {
	        updateSql += ", dday = '" + this.dDay + "'";
	    } else {
	        updateSql += ", dday = null";
	    }
	    return updateSql;
		
		
	}


	
}
