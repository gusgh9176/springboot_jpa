var main = {
    init : function () {
        var _this = this;
        $('tbody').hide();
        $('#tbodySkeleton').show();
        $('#tbody-purchaseList').show();

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
            url: '/materials',
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data),
            beforeSend: function (request) {
                request.setRequestHeader("X-CSRF-TOKEN",token)
            }
        }).done(function() {
            alert('글이 등록되었습니다.');
            location.reload();
        }).fail(function (error) {
            alert(error);
        });
    }
};

main.init();
