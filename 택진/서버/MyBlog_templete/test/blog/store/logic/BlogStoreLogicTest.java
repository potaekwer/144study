package blog.store.logic;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import blog.domain.Author;
import blog.domain.Blog;

public class BlogStoreLogicTest {
	
	private BlogStoreLogic store;
	
	@Before
	public void setUp(){
		store = new BlogStoreLogic();
	}

	@Test
	public void testFindBlog() {
		Blog blog = store.findBlog(1);
		assertEquals("하늘바람별", blog.getTitle());
		assertEquals("demonpark", blog.getAuthor().getId());
		assertNotNull(blog.getPosts());
		assertEquals(2, blog.getPosts().size());
		assertEquals("mybatis", blog.getPosts().get(0).getSubject());
		assertEquals("mybatis의 이해와 적용", blog.getPosts().get(0).getContents());

	}

	@Test
	public void testFindBlogByAuthorId() {
		Blog blog = store.findBlogByAuthorId("demonpark");
		assertEquals(1, blog.getId());
		assertEquals("하늘바람별", blog.getTitle());
	}

	@Test
	public void testFindAllBlogs() {
		List<Blog> list = store.findAllBlogs();
//		assertEquals(4, list.size());
	}

	@Test
	public void testFindBlogsByTitle() {
		List<Blog> list = store.findBlogsByTitle("하늘");
		assertEquals(1, list.size());
		assertEquals("demonpark", list.get(0).getAuthor().getId());
	}

	@Test
	public void testRegistBlog() {
//		Blog blog = new Blog();
//		Author a = new Author("name", "passwd", "email");
//		blog.setAuthor(a);
//		blog.setTitle("title");
//		store.registBlog(blog);
//		assertEquals(4, store.findAllBlogs().size());
	}

//	@Test
//	public void testUpdateBlog() {
//		Blog blog = store.findBlogByAuthorId("name");
//		blog.setTitle("updated");
//		assertEquals(1, store.updateBlog(blog));
//		assertEquals("updated", store.findBlogByAuthorId("name").getTitle());
//	}

//	@Test
//	public void testDeleteBlog() {
//		assertEquals(1, store.deleteBlog(24));
//		assertEquals(3, store.findAllBlogs().size());
//	}

}
