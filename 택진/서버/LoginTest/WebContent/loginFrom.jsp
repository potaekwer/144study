<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

<script type="text/javascript">
	$(document).ready(function(){





</head>
<body>
<body>
 <!--     
        <div>
            내용입력 : <input type="text" name="name"><br>
            <button>확인</button>
                          
                          
                          
        </div>
        
        <script>
            $("button").click(function(){
                $("input").val("Hello");
//                $("div").text($("text").val());

                
            });
            
//            $("input").val("Hello").css("colo","acccccc").focus(function(){//포커스가 가면 지워짐
//                            $(this).val("").css("color", "red");
//            });
//            
            
            $("input").val("Hello").css("colo","acccccc").one("focus", function(){//포커스가 처음에만 지워짐
                    $(this).val("").css("color", "red");
            });
            
            
        
        </script>
    -->
        
        <form action="javascript:alert('전송완료')">
        
            <dt>이름</dt>
            <dd>
            
                <input type="text" name="name">
            
            </dd>
            <dt>연락처</dt>
            <dd>
            
                <input type="text" name="phoneNum">
            
            </dd>
            <dt>이메일</dt>
            <dd>
                <input type="text" name="email">
            </dd>
            <dt>이메일 확인</dt>
            <dd>
                <input type="text" name="email">
            </dd>
            <dl>
            <dt>성별</dt>
            <dd>
                <input type="radio" name="career" id="yes"><label for="yes">유</label>
                <input type="radio" name="career" id="no"><label for="no">무</label>
                    
            </dd>
            <dt>취미</dt>
            <dd>
                <input type="checkbox"><label>음악듣기</label>
                <input type="checkbox"><label>영화보기</label>
                <input type="checkbox"><label>책읽기</label>
                <span><button>전부체크</button></span>
                    
            </dd>
            
            <dt>자기소개</dt>
            <dd>
                <textarea name="comment"></textarea>
                    
            </dd>
            
            </dl>
            <input type="submit" value="확인">
            <input type="reset" value="취소">
            
        </form>
        
        
        <script>
            
            $("form").submit(function(){
                if($("input[name = 'id']").val()==""){
                    $("input[name = 'id']").css("border","1px solid red").after("<span>아이디를 입력해 주세요</span>");
                    $("span").css("color", "red").fadeOut(2000);//2초 동안 span 보여주기
                    return false;
                    
                }
            });
            
            $(":input").focus(function(){
                $(this).css("border", "2px red solid");
                
            }).blur(function(){
                $(this).css("border","");
            });
        
            
            $(":text").focus(function(){
                $(this).after("<strong>필수 항목 입니다. </strong>")
                
            }).blur(function(){
                $("strong").remove();
            });
        
            $(":password").focus(function(){
                $(this).after("<strong>영문 숫자 조합 입니다. </strong>")
                
            }).blur(function(){
                $("strong").remove();
            });
            
            
            //라디오 버튼 선택시 폰트 변경
            
//            $(":radio").click(function(){
//                $("label").css("font-weight", "")
//                $("label[for='" + $(this).attr("id") + "']").css("font-weight","bold");
//            })
            
            
            $("label").click(function(){
                $("label").css("font-weight","");
                $(this).css("font-weight","bold");
            });

            
            
            
            
            
            $("button").click(function(){
                $(":checkbox").attr("checked", "checked");
                return false;
            })
            
            
            
            
            
            $(":submit").mouseover(function(){
                $(":reset").after("<p>회원 가입을 하시겠습니까?</p>");
                $("p").css("color","blue");
                
            }).mouseout(function(){
                $("p").remove();
            })
            
             $(":reset").mouseover(function(){
                $(this).after("<p>다시 작성 하시겠습니까?</p>");
                $("p").css("color","blue");
                
            }).mouseout(function(){
                $("p").remove();
            })
            
            
            
        </script>
        
        
        
        
    
    </body>
</html>