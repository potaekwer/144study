package blog.store.logic;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import blog.domain.Author;
import blog.domain.Blog;
import blog.domain.Post;

public class PostStoreLogicTest {
	
	private PostStoreLogic store;
	
	@Before
	public void setUp(){
		store = new PostStoreLogic();
	}

//	@Test
//	public void testFindPost() {
//		assertEquals("mybatis", store.findPost(1).getSubject());
//		assertEquals("mybatis3", store.findPost(2).getSubject());
//	}
//
//	@Test
//	public void testFindAllPost() {
//		assertEquals(3, store.findAllPost().size());
//		assertEquals("mybatis", store.findAllPost().get(0).getSubject());
//	}

//	@Test
//	public void testFindPostsByBlogId() {
//		assertEquals(2, store.findPostsByBlogId(1).size());
//	}

//	@Test
//	public void testFindPostsByAuthorName() {
//		assertEquals(2, store.findPostsByAuthorName("¹Ú").size());
//	}
//
//	@Test
//	public void testFindPostsByBlogTitle() {
//		assertEquals(2, store.findPostsByBlogTitle("¹Ù¶÷").size() );
//	}

//	@Test
//	public void testFindPostsBySubject() {
//		assertEquals(2, store.findPostsBySubject("my").size());
//	}
//
//	@Test
//	public void testFindPostsByContents() {
//		assertEquals(2, store.findPostsByContents("my").size());
//	}
//
	@Test
	public void testRegistPost() {
		Post p = new Post();
		Author a = new Author("n", "p", "e");
		Blog b = new Blog();
		b.setAuthor(a);
		b.setId(59);
		b.setTitle("t");
		p.setAuthor(a);
		p.setBlog(b);
		p.setSubject("sub");
		p.setContents("con");
		
		store.registPost(p);
	}
//
//	@Test
//	public void testUpdatePost() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testDeletePost() {
//		fail("Not yet implemented");
//	}

}
