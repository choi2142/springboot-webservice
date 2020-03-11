var main = {
    init : function () {
        var _this = this;
        $('#btn-save').on('click', function () {
            _this.save();
        });
        $('#btn-update').on('click', function () {
            _this.update();
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
			
			var realno = $("#id").html();
			
			console.log("realid : " + realno);
	    	
	    	// tr.text()는 클릭된 Row 즉 tr에 있는 모든 값을 가져온다.
			console.log("클릭한 Row의 모든 데이터 : "+tr.text());                
			$("#id2").html(no);
			$("#content2").html(content);
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
    }
};

main.init();