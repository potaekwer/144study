package blog.store.mapper;

import java.util.List;

import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import blog.domain.Post;

public interface PostMapper {
	
	Post findPost(int id);

	List<Post> findAllPost();
	
	
	@Results({
		@Result(property="id", column="id"),
		@Result(property="subject", column="subject"),
		@Result(property="contents", column="contents"),
		@Result(property="author", column="author_id", one=@One(select="AuthorStore.findAuthor")),
		@Result(property="blog", column="blog_id", one=@One(select="BlogStore.findBlog"))
	})
	@Select("SELECT id, subject, contents FROM post_tb WHERE blog_id = #{id} ORDER BY id")
	List<Post> findPostsByBlogId(int id);

	List<Post> findPostsByAuthorName(String authorName);

	List<Post> findPostsByBlogTitle(String blogTitle);

	List<Post> findPostsBySubject(String subject);

	List<Post> findPostsByContents(String contents);

	int registPost(Post post);

	int updatePost(Post post);

	int deletePost(int id);

}
