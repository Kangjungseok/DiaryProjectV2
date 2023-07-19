package dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class DiaryDTO extends DTO{
	
	String email;
	String spaceCode;
	int taskIndex;
	String task;
	String manager;
	Date dDay;
	
	
	public DiaryDTO(String spaceCode, int taskIndex) {
		super();
		this.spaceCode = spaceCode;
		this.taskIndex = taskIndex;
	}
	
	public String getAllValues() {
		String emailSql = "\'"+ email +"\'";
		String spaceCodeSql = "\'"+ spaceCode +"\'";
		String taskSql = "\'"+ task +"\'";
		String managerSql = "\'"+ manager +"\'";
		String dDaySql = "\'"+ dDay +"\'";
		
		String sql = emailSql+", "+ spaceCodeSql + ", " + taskSql + ", " + managerSql + ", " + dDaySql;
		
		return sql;
	}

	
	
}
