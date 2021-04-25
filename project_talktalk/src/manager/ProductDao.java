package manager;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.util.MyBatisCommonFactory;

public class ProductDao {
	SqlSessionFactory sqlSessionFactory = null;
	SqlSession sqlSession = null;
	//전체조회
	public void refresh(ProductCon pc) {
		//연결 베이스///////////////////////////////////////
		sqlSessionFactory = MyBatisCommonFactory.getInstance();
		List<Map<String,Object>> map = new ArrayList<>();
		try {
			sqlSession = sqlSessionFactory.openSession();
			sqlSession.selectList("mybatis.ProcMapper1.refresh", map);
		} catch (Exception e) {
			// TODO: handle exception
		}
		for(Map<String,Object> map1 : map) {
			System.out.println(map1.get("mem_no"));
			Vector<Object> v = new Vector<>();
			v.add(map1.get("mem_no"));
			pc.pv.dtm_dept.addRow(v);
		}
		
	}
	
}
