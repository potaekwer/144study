<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="EUC-KR"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>ȸ������</title>
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
        $("#id").keyup(function(){
            if($("#id").val().length > 5){
                var id = $(this).val();
                $.ajax({
                    type: 'POST',
                    url:'checkId.do',
                    data:
                    {   
                        id : id
                    },
                    success: function(result){
                        if($.trim(result)=='ok'){
                            $("#idCheckResult").html("��� ������ ID�Դϴ�.");
                        }else{
                            $("#idCheckResult").html("��� ���� ID �Դϴ�.")
                        }
                    }
                })
            }else{
                $("#idCheckResult").html("5�� �̻��Դϴ�..")
            }
        });
    });
	</script>
</head>
<body>
	<input type="text" id="id" name="idCheck">
	<span id="idCheckResult"></span>
</body>
</html>