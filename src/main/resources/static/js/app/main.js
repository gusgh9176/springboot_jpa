var main = {
    init : function () {
        var _this = this;
        var id = $('.classification').length;
        $('tbody').hide();
        $('#tbodySkeleton').show();
        $('#tbody-purchaseList').show();

        $('#btn-save').on('click', function () {
            _this.save();
        });

        $('#btn-skeleton').on('click', function () {
            _this.skeletonNext();
        });
        $('#btn-insulation').on('click', function () {
            _this.insulationNext();
        });
        $('#btn-exterior').on('click', function () {
            _this.exteriorNext();
        });
        $('#btn-interior').on('click', function () {
            _this.interiorNext();
        });
        $('#btn-window').on('click', function () {
            _this.windowNext();
        });


        $('#btn-test').on('click',function () {
            _this.test();
        });
        $('#btn-test2').on('click',function () {
            _this.test2();
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
            url: '/materials',
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

    skeletonNext : function () {
        $('#tbodySkeleton').hide();
        $('#tbodyInsulation').show();
    },
    insulationNext : function () {
        $('#tbodyInsulation').hide();
        $('#tbodyExterior').show();
    },
    exteriorNext : function () {
        $('#tbodyExterior').hide();
        $('#tbodyInterior').show();
    },
    interiorNext : function () {
        $('#tbodyInterior').hide();
        $('#tbodyWindow').show();
    },
    windowNext : function () {
        $('#tbodyWindow').hide();
        $('#tbodySkeleton').show();
        alert("선택항목이 구매리스트에 올라갔습니다.")
    },

    addPurchaseList : function () {

    },

    test : function () {
        $('#tbodySkeleton').show();
    },
    test2 : function () {
        $('#tbodySkeleton').hide();
    }

};

main.init();
