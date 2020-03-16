var main = {
    init : function () {
        var _this = this;
        var page = 1;
        $('#btn-save').on('click', function () {
            _this.save();
        });
        $('#btn-update').on('click', function () {
            _this.update();
        });
        $('#btn-delete').on('click', function () {
            _this.delete();
        });
        // 테이블의 Row 클릭시 값 가져오기
    	$("#example-talbe tr").click(function(){ 	
    		var str =""
	   		var tdArr = new Array();	    	
	    	// 현재 클립된 Row
	    	var tr = $(this);
	    	var td = tr.children();
	    	var no = td.eq(0).text();
			var content = td.eq(4).text();
			
			$("#id2").val(no);
			$("#content2").val(content);
			
        });
    	$(window).scroll(function() {
            if ($(window).scrollTop() == $(document).height() - $(window).height()) {
            	var lastbno = $(".scrolling:last").attr("data-bno");
            	
            	$.ajax({
            		type : 'POST', // 요청 method 방식
            		url    :'/scrollDown', //요청할 서버의 url
            		header : {
            			"content-type" : "application/json",
            			"X-HTTP-Method-Overrid" : "POST"
            		},
            		dataType : 'json',
            		data : JSON.stringify({
            			bno : lastbno
            		}),
            		
            		success : function(data){
            			var str ="";
            			
            			if(data != ""){
            				$(data).each(
            						function(){
            							console.log(this);
            							str += "<tr class=" + "'listToChange'" + ">"
            								 +		"<td class=" + "'scrolling'" + " data-bno='" + this.bno +"'>"
            								 +			this.bno
            								 +		"</td>"
            								 +		"<td style=" + "'cusor:pointer'" + " data-toggle=" + "'modal'" + "data-target=" + "'#modifyPostsModal'" + "'>"
            								 +			this.title
            								 +		"</td>"
            								 +		"<td>" + this.modifiedDate  + "</td>"            								 
            								 +		"<td style=" + "'visibility:hidden'" + "'>" + this.content +"</td>"
            								 +		"</tr>";
            						});
            						$(".listToChange").empty();
            						$(".scrollLocation").after(str);
            			}
            			else{
            				alert("더 불러올 데이터가 없습니다.");
            			}
            		}
            	})
            	            	
            }
        });

    },
    save : function () {
        var data = {
            title: $('#title').val(),
            author: $('#author').val(),
            content: $('#content').val()
        };

        $.ajax({
            type: 'POST',
            url: '/posts',
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('글이 등록되었습니다.');
            location.reload();
        }).fail(function (error) {
            alert(error);
        });
    },
    update : function () {
        var data = {
        	id: $('#id2').val(),
            content: $('#content2').val()
        };

        $.ajax({
            type: 'POST',
            url: '/postsupdate',
            dataType: 'text',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('글이 수정되었습니다.');
            location.reload();
        }).fail(function (error) {
            alert(error);
        });
    },
    delete : function () {
        var data = {
        	id: $('#id2').val()
        };

        $.ajax({
            type: 'POST',
            url: '/postsdelete',
            dataType: 'text',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {            
            location.reload();
        }).fail(function (error) {
            alert(error);
        });
    }
};

main.init();