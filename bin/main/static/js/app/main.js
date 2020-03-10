var main = {
    init : function () {
        var _this = this;
        $('#btn-save').on('click', function () {
            _this.save();
        });
        $('#btn-update').on('click', function () {
            _this.update();
        });
        $('#btn-detail').on('click', function () {
            _this.detail();
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
        var data2 = {
        	id: $('#id').val(),
            title: $('#title2').val(),
            author: $('#author2').val(),
            content: $('#content2').val()
        };

        $.ajax({
            type: 'POST',
            url: '/postsupdate',
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data2: JSON.stringify(data2)
        }).done(function() {
            alert('글이 수정되었습니다.');
            location.reload();
        }).fail(function (error) {
            alert(error);
        });
    }
    ,
    detail : function () {
        var data3 = {
        	id: $('#list_id').val(),
            title: $('#btn-detail').val(),
            author: $('#list_author').val()
        };

        $.ajax({
            type: 'POST',
            url: '/postsupdate',
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data2: JSON.stringify(data3)
        }).done(function() {
            alert('글이 수정되었습니다.');
            location.reload();
        }).fail(function (error) {
            alert(error);
        });
    }

};

main.init();