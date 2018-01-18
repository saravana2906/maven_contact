package com.contacts.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import com.contacts.beans.ContactPhone;
import com.contacts.util.DatabaseUtil;

public class ContactPhoneDaoImpl implements ContactPhoneDao {
	
	public static String add_phone="insert into contacts.contact_phone values(null,?,?,now(),now())";
	public static String user_phone="select uc.contact_id,cp.phone_id,cp.phone_number from contacts.user_contact uc,contacts.contact_phone cp where cp.contact_id=uc.contact_id and uc.user_id= ? order by uc.contact_id,cp.phone_id";
	public static String delete_contact="delete from contacts.contact_phone where contact_id=? ";
	public static String get_phone="select contact_id,phone_id,phone_number from contacts.contact_phone where contact_id=?";
	public static String delete_phone="delete from contacts.contact_phone where phone_id=?";
	public static String update_phone="update contacts.contact_phone set phone_number=?,updated_date=now() where phone_id=?";

	public boolean addPhoneno(ContactPhone phone) {
		// TODO Auto-generated method stub
		Connection con=DatabaseUtil.getConnection();
		try {
			for(String tmp_phone : phone.getPhonenumber())
			{
				PreparedStatement stmt=con.prepareStatement(ContactPhoneDaoImpl.add_phone);
				stmt.setLong(1,phone.getContactid());
				stmt.setString(2, tmp_phone);
				stmt.executeUpdate();
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		return true;
	}


	public boolean deletePhoneno(long phoneid, long contactid) {
		// TODO Auto-generated method stub
		Connection con=DatabaseUtil.getConnection();
		int count=0;
		try {
			PreparedStatement stmt=con.prepareStatement(ContactPhoneDaoImpl.delete_phone);
			stmt.setLong(1,phoneid);
			count=stmt.executeUpdate();
			System.out.println("In Delte single Phone" + count);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(count>0)
		{
			return true;
		}
		return false;
	}

	public boolean deletePhoneno(long contactid) {
		// TODO Auto-generated method stub
		Connection con=DatabaseUtil.getConnection();
		int count=0;
		try {
			PreparedStatement stmt=con.prepareStatement(ContactPhoneDaoImpl.delete_contact);
			stmt.setLong(1, contactid);
			count=stmt.executeUpdate();
			System.out.println(count);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(count>0)
		{
			return true;
		}
		return false;
	} 



	public boolean updatePhoneno(long phoneid, String phonenumber) {
		// TODO Auto-generated method stub
		Connection con=DatabaseUtil.getConnection();
		int count=0;
		try {
			PreparedStatement stmt=con.prepareStatement(ContactPhoneDaoImpl.update_phone);
			stmt.setString(1,phonenumber);
			stmt.setLong(2, phoneid);
			count=stmt.executeUpdate();
			System.out.println(count);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(count>0)
		{
			return true;
		}
		return false;
		}


	public HashMap<Long, ContactPhone> getAllUserPhones(long userid) {
		// TODO Auto-generated method stub
		Connection con=DatabaseUtil.getConnection();
		HashMap<Long, ContactPhone> conphone=new HashMap<Long, ContactPhone>();
		ResultSet rs=null;
		try {
			PreparedStatement stmt=con.prepareStatement(ContactPhoneDaoImpl.user_phone);
			stmt.setLong(1,userid);
			rs=stmt.executeQuery();
			while(rs.next())
			{
			if(conphone.containsKey(rs.getLong(1))){
				ContactPhone tmp=conphone.get(rs.getLong(1));
				tmp.getPhoneid().add(rs.getLong(2));
				tmp.getPhonenumber().add(rs.getString(3));
				System.out.println(rs.getString(3));
			conphone.put(rs.getLong(1), tmp);
				
			}
			else
			{
				ContactPhone tmp=new ContactPhone();
				List<Long> phoneid=new ArrayList<Long>();
				phoneid.add(rs.getLong(2));
				List<String> phoneno=new ArrayList<String>();
				phoneno.add(rs.getString(3));
				System.out.println(rs.getString(3));
				tmp.setPhoneid(phoneid);
				tmp.setPhonenumber(phoneno);
				tmp.setContactid(rs.getLong(1));
				conphone.put(rs.getLong(1),tmp);
			} 
				
				
			}
			return conphone;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	
	return null;	
	}


	public ContactPhone getPhoneno(long contactid) {
		// TODO Auto-generated method stub
		Connection con=DatabaseUtil.getConnection();
		ContactPhone conphone=new ContactPhone();
		List<Long> phoneid=new ArrayList<Long>();
		List<String> phoneno=new ArrayList<String>();
		ResultSet rs=null;
		try {
			PreparedStatement stmt=con.prepareStatement(ContactPhoneDaoImpl.get_phone);
			stmt.setLong(1,contactid);
			rs=stmt.executeQuery();
			while(rs.next())
			{
				phoneid.add(rs.getLong(2));
				phoneno.add(rs.getString(3));
				conphone.setPhoneid(phoneid);
				conphone.setPhonenumber(phoneno);
				conphone.setContactid(rs.getLong(1));
			} 
			return conphone;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

}
