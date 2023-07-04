package web005_Mybatis_JSPContoller_User;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.junit.Test;

import com.min.edu.dao.IUserDao;
import com.min.edu.dao.UserDaoImpl;
import com.min.edu.dto.UserDto;
import com.min.edu.support.SqlSessionFactoryManager;

public class MemberInfoJunitTest {

	SqlSession session;
	// com.min.edu.dao.UserDaoImpl.
	IUserDao dao = new UserDaoImpl();
	
//	@Before
//	public void test() {
//		SqlSessionFactory manager = SqlSessionFactoryManager.getFactory();
//		session = manager.openSession();
//		assertNotNull(session);
//	}
	
//	@Test
	public void memberInfo_test() {
//		List<UserDto> lists = session.selectList("com.min.edu.dao.UserDaoImpl.getAllUserStatus");
//		assertNotNull(lists);
		
//		List<UserDto> lists2 = session.selectList("com.min.edu.dao.UserDaoImpl.getAllUser");
//		assertNotNull(lists2);
		
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("auth", "USER");
//		map.put("seq", 1);
//		int row = session.update("com.min.edu.dao.UserDaoImpl.updateAuthUser", map);
//		session.commit();
//		assertEquals(row, 1);
		
//		UserDto dto = new UserDto("hyeon", "1234", "sohyeon", "서울", "01022", "so960828@gmail.com");
//		int row2 = session.insert("com.min.edu.dao.UserDaoImpl.insertUser", dto);
//		assertEquals(row2, 1);
		
//		Map<String, Object> map2 = new HashMap<String, Object>();
//		map2.put("id", "hyeon");
//		map2.put("password", "1234");
//		List<UserDto> lists3 = session.selectList("com.min.edu.dao.UserDaoImpl.getLogin",map2); 
//		assertNotNull(lists3.get(0));
		
//		List<UserDto> list4 = session.selectList("com.min.edu.dao.UserDaoImpl.getUserInfo", "1");
//		assertNotNull(list4.get(0));
		
//		Map<String, Object> map3 = new HashMap<String, Object>();
//		map3.put("address", "서울 영등포구");
//		map3.put("phone", "001");
//		map3.put("email", "hyeon@info.co.kr");
//		map3.put("seq", "4");
//		int row3 = session.update("com.min.edu.dao.UserDaoImpl.updateUserInfo", map3);
//		assertEquals(row3, 1);
		
//		int row4 = session.delete("com.min.edu.dao.UserDaoImpl.delUser", "4");
//		assertEquals(row4, 1);
		
//		int result = session.selectOne("com.min.edu.dao.UserDaoImpl.duplicateId", "hyeon");
//		assertEquals(result, 1);
	}
	
//	@Test
	public void daoTest() {
//		List<UserDto> lists = dao.getAllUserStatus();
//		assertNotNull(lists);
		
//		List<UserDto> lists2 = dao.getAllUser();
//		assertNotNull(lists2);
		
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("auth", "ADMIN");
//		map.put("seq", 4);
//		int row = dao.updateAuthUser(map);
//		assertEquals(row, 1);
		
//		UserDto dto = new UserDto("hi", "1234", "sohyeon", "서울", "01022", "hi@gmail.com");
//		int row2 = dao.insertUser(dto);
//		assertEquals(row2, 1);
		
//		Map<String, Object> map2 = new HashMap<String, Object>();
//		map2.put("id", "hi");
//		map2.put("password", "1234");
//		UserDto dto = dao.getLogin(map2);
//		assertNotNull(dto);
		
//		UserDto dto2 = dao.getUserInfo("5");
//		assertNotNull(dto2);
		
//		Map<String, Object> map3 = new HashMap<String, Object>();
//		map3.put("address", "서울 영등포구");
//		map3.put("phone", "001");
//		map3.put("email", "hyeon@info.co.kr");
//		map3.put("seq", "4");
//		int row3 = dao.updateUserInfo(map3);
//		assertEquals(row3, 1);
		
//		int row4 = dao.delUser("5");
//		assertEquals(row4, 1);
		
		int result = dao.duplicateId("hi");
		assertEquals(result, 1);
	}

}
