var flag = true;

var main = {
    init : function () {
        var _this = this;
        $('#btn-save').on('click', function () {
            _this.save();
        });
        $('#btn-update').on('click', function () {
            _this.update();
        });
        $('#btn-delete').on('click', function () {
            _this.delete();
        });
    	// 페이징 처리    	
    	$("#pagination").twbsPagination({
        	totalPages: 10,
        	visiblePages: 5,
        	initiateStartPageClick:false,

        	onPageClick: function (event, page) {
        		redraw(page);
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
            type: 'GET',
            url: '/postsdelete',
            dataType: 'text',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {          
        	 alert('글이 삭제되었습니다.');
        	 location.reload();
        }).fail(function (error) {
            alert(error);
        });
    }
};

function detail(id){
	$(location).attr('href', '/board/board_detail?id='+id)
}

function redraw(page){
	if(flag){
		flag = false;
		$.ajax({
			type : 'GET',
			url : '/board/board_list_page?page='+page,
			dataType: 'text'
		}).done(function(data){
			// innerHtml 작성
			var obj = JSON.parse(data);
			var content ="";
			console.log(obj.content[0].id);
			for(var i =0;obj.content.length > i;i++){
				content 		 += "<tr><td class=\"scrolling\" data-bno="+obj.content[i].id+"} >"+obj.content[i].id+"</td>"
			     +  "<td  style=\"cursor:pointer\" >"
			     +  "<a href=\"javascript:detail("+obj.content[i].id+");\">"+obj.content[i].title+"</a>"
			     + "</td>"
			     +  "<td>"+obj.content[i].author+"</td>"
			     +  "<td>"+obj.content[i].modifiedDate+"</td>";
			}			 
			
			$('#tbody').empty().append(content);
			
			$("#pagination").twbsPagination("changeTotalPages", obj.totalPages, obj.number+1);
			
		}).fail(function(error){
			console.log('fail' + error);
		}).always(function(){
			flag = true;
		});
	}
}

main.init();