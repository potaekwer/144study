package blog.store.logic;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import blog.domain.Blog;
import blog.store.facade.BlogStore;
import blog.store.mapper.BlogMapper;

public class BlogStoreLogic implements BlogStore{
	
	private SqlSessionFactory factory;
	
	public BlogStoreLogic() {
		factory = SqlSessionFactoryProvider.getSqlSessionFactory();
	}

	@Override
	public Blog findBlog(int id) {
		SqlSession session = factory.openSession();
		Blog blog = null;
		try{
			BlogMapper mapper = session.getMapper(BlogMapper.class);
			blog = mapper.findBlog(id);
		}finally{
			session.close();
		}
		return blog;
	}

	@Override
	public Blog findBlogByAuthorId(String authorId) {
		SqlSession session = factory.openSession();
		Blog blog = null;
		try{
			BlogMapper mapper = session.getMapper(BlogMapper.class);
			blog = mapper.findBlogByAuthorId(authorId);
		}finally{
			session.close();
		}
		return blog;
	}

	@Override
	public List<Blog> findAllBlogs() {
		SqlSession session = factory.openSession();
		List<Blog> list = null;
		try{
			BlogMapper mapper = session.getMapper(BlogMapper.class);
			list = mapper.findAllBlogs();
		}finally{
			session.close();
		}
		return list;
	}

	@Override
	public List<Blog> findBlogsByTitle(String title) {
		SqlSession session = factory.openSession();
		List<Blog> list = null;
		HashMap<String, String> map = new HashMap<>();
		map.put("title", title);
		try{
//			BlogMapper mapper = session.getMapper(BlogMapper.class);
//			list = mapper.findBlogsByTitle(title);
			list = session.selectList("findBlogsByTitle", map);
		}finally{
			session.close();
		}
		return list;
	}

	@Override
	public void registBlog(Blog blog) {
		SqlSession session = factory.openSession();
		try{
			BlogMapper mapper = session.getMapper(BlogMapper.class);
			mapper.registBlog(blog);
			session.commit();
		}finally{
			session.close();
		}
	}

	@Override
	public int updateBlog(Blog blog) {
		SqlSession session = factory.openSession();
		try{
			BlogMapper mapper = session.getMapper(BlogMapper.class);
			int result = mapper.updateBlog(blog);
			if(result > 0){
				session.commit();
			}else{
				session.rollback();
			}
			return result;
		}finally{
			session.close();
		}
	}

	@Override
	public int deleteBlog(int id) {
		SqlSession session = factory.openSession();
		try{
			BlogMapper mapper = session.getMapper(BlogMapper.class);
			int result = mapper.deleteBlog(id);
			if(result > 0){
				session.commit();
			}else{
				session.rollback();
			}
			return result;
		}finally{
			session.close();
		}
	}

}
