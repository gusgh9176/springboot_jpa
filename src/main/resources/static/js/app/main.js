var main = {
    init : function () {
        var _this = this;
        $('#tbodyInsulation').hide();
        $('#tbodyExterior').hide();
        $('#tbodyInterior').hide();
        $('#tbodyWindow').hide();
        

        $('#btn-save').on('click', function () {
            _this.save();
        });
    },
    save : function () {
        var token = $('input#csrf-token').attr("value");
        var data = {
            classification: $('#classification').val(),
            item: $('#item').val(),
            standard: $('#standard').val(),
            price: $('#price').val()
        };

        $.ajax({
            type: 'POST',
            url: '/materials/insert',
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data),
            beforeSend: function (request) {
                request.setRequestHeader("X-CSRF-TOKEN",token)
            }
        }).done(function() {
            alert('재료가 등록되었습니다.');
            location.reload();
        }).fail(function () {
            alert("잘못된 입력입니다.");
        });
    },
    delete : function () {
        var token = $('input#csrf-token').attr("value");
        var data = {
            id: $('#id').val()
        };

        $.ajax({
            type: 'POST',
            url: '/materials/delete',
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data),
            beforeSend: function (request) {
                request.setRequestHeader("X-CSRF-TOKEN",token)
            }
        }).done(function() {
            alert('재료가 삭제되었습니다.');
            location.reload();
        }).fail(function (error) {
            alert(error);
        });
    }
};

main.init();
