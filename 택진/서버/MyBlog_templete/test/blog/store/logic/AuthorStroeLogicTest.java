package blog.store.logic;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import blog.domain.Author;

public class AuthorStroeLogicTest {
	
	private AuthorStoreLogic store;
	
	@Before
	public void setUp(){
		store = new AuthorStoreLogic();
	}

//	@Test
//	public void testFindAuthor() {
//		Author a = store.findAuthor("demonpark");
//		assertNotNull(a);
//		assertEquals("demonpark", a.getId());
//	}

//	@Test
//	public void testFindAllAuthors() {
//		List<Author> list = store.findAllAuthors();
//		assertEquals(5, list.size());
//		assertEquals("한승용", list.get(0).getName());
//	}

//	@Test
//	public void testFindAuthorsByName() {
//		List<Author> list = store.findAuthorsByName("박데몬");
//		assertEquals(1, list.size());
//		assertEquals("demonpark", list.get(0).getId());
//	}
//
//	@Test
//	public void testRegistAuthor() {
//		Author a = new Author("name", "passwd", "email");
//		a.setId("id");
//		store.registAuthor(a);
//		assertNotNull(store.findAuthor("id"));
//		assertEquals(6, store.findAllAuthors().size());
//	}
//
//	@Test
//	public void testUpdateAuthor() {
//		Author a = new Author("형문", "1234", "1234");
//		a.setId("id");
//		assertEquals(1, store.updateAuthor(a));
//		assertEquals("형문", store.findAuthor("id").getName());
//	}
//
//	@Test
//	public void testDeleteAuthor() {
//		assertEquals(1, store.deleteAuthor("id"));
//		assertEquals(5, store.findAllAuthors().size());
//	}
//
//	@Test
//	public void testFindAuthorsByIds() {
//		List<String> ids = new ArrayList<>();
//		ids.add("demonpark");
//		ids.add("kimgisa");
//		List<Author> list = store.findAuthorsByIds(ids);
//		assertEquals(2, list.size());
//		
//	}
//
//	@Test
//	public void testFindAuthorByCondition() {
//		Map<String, String> map = new HashMap<>();
//		map.put("id", "demonpark");
//		List<Author> list = store.findAuthorByCondition(map);
//		assertEquals(1, list.size());
//		map.remove("id");
//		list = store.findAuthorByCondition(map);
//		assertEquals(5, list.size());
//	}

}
