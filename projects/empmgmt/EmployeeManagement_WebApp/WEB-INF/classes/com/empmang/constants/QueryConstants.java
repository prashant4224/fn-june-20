package com.empmang.constants;

public class QueryConstants {
	// Migrated to PL/SQL Stored Proc.
	// public static final String QRY_USR_VALIDATE =
	// "select userid,password,role from login_master where userid =? ";
	public static final String CREATE_RL = "insert into compliance(complianceid, rlType,details,createDate,DEPARTMENT_ID) values (compliance_seq.NEXTVAL,?,?,?,? )";
	public static final String CREATE_STATUS = "SELECT complianceid as complianceid FROM statusreport";
	// Migrated to PL/SQL Function
	/*
	 * public static final String SELECT_RL =
	 * "select com.complianceid as complianceid,rlType,details,com.createDate,com.department_id as department_id,"
	 * +
	 * " department_nm, count(distinct emp.empid) AS empcount , count(distinct sts.empid) as statuscount from"
	 * +
	 * " department dept,employees emp,compliance com left outer join statusreport sts"
	 * +
	 * " on sts.department_id = com.department_id  and sts.complianceid = com.complianceid"
	 * +" where  com.department_id = emp.department_id"
	 * +" and com.department_id = dept.department_id"
	 * +" group by com.complianceid,com.department_id";
	 */
	public static final String SELECT_RL_USER = "select complianceid,rlType,createdate,com.department_id as department_id,department_nm,details from compliance com,department depart,employees emp where com.department_id = depart.department_id and emp.department_id = depart.department_id and emp.empid = ?";
	public static final String SELECT_DEPARTMENT = "select department_id from compliance where complianceid=?";
	public static final String CREATE_STATUSREPORT = "insert into statusreport(statusrptid, comments,createDate,department_id ,empid,complianceid) values (statusreport_seq.NEXTVAL,?,?,?,?,?)";
	public static final String SELECT_STATUSREPORT = "select distinct statusrptid,comments,sts.createdate,sts.department_id as department_id,department_nm "
			+ "from statusreport sts,department depart,employees emp where sts.department_id = depart.department_id  "
			+ "and emp.department_id = depart.department_id and sts.empid = ? and sts.complianceid = ? order by statusrptid";
	public static final String CREATE_DEPARTMENT = "insert into department(DEPARTMENT_ID, DEPARTMENT_NM) values (department_seq.NEXTVAL,? )";
	public static final String SELECT_DEPT = "select * from department order by department_id";
	
	public static final String SELECT_PAGINATION_DEPT = "select * from ( sele-ct a.*, rownum rnum from ( SELECT * FROM department order by department_id ) a where rownum <= ? ) where rnum >?";
	
	public static final String SELECT_DEPT_COUNT = "Select count(*) from department";
	
	public static final String SELECT_EMP_COUNT = "Select count(*) from employees";
	
	public static final String SELECT_PAGINATION_EMP = "select * from" +
			" ( select a.*, rownum rnum from " +
			"( SELECT empid, firstname, lastname, dob, email, department.department_nm FROM employees " +
			"join department on employees.department_id = department.department_id order by empid ) a where rownum <= ? ) where rnum >?";
	
	public static final String DELETE_DEPT = "select count(empid) as count from employees where department_id = ?";
	// Migrated to PL/SQL Stored Proc.
	// public static final String CREATE_EMPLOYEE =
	// "insert into employees(firstname,lastname,dob,email,department_id) values (?, ?, ?, ?,? )";
	// public static final String CREATE_LOGIN =
	// "insert into login_master(userid,password,role) values ((select empid from employees where firstname =? and lastname =?), ?, ? )";
	public static final String DELETE_EMP = "delete from employees where empid=?";
	public static final String DELETE_EMP_LOGIN = "delete from LOGIN_MASTER where userid=?";
	public static final String UPDATE_EMP = "update employees set firstname=?, lastname=?, dob=?, email=?, department_id=? "
			+ "where empid=?";
	// Migrated to PL/SQL Stored Proc.
	/*
	 * public static final String SELECT_EMP =
	 * "select empid,firstname,lastname,dob,email,department_nm" +
	 * " from employees emp left outer join  department depart on emp.department_id = depart.department_id"
	 * ;
	 */
	public static final String GET_EMPDTL = "select empid,firstname,lastname,dob,email,emp.department_id as depart_id,department_nm from employees emp, department dept"
			+ " where empid=? and emp.department_id = dept.department_id";
	public static final String CHK_STATUS = "SELECT count(*) as count FROM statusreport where empid =?";
}
