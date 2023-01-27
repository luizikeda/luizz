Index.MaskPhoneNumber = (function() {
    function MaskPhoneNumber() {
        this.inputPhoneNumber = $('.js-phone-number');
    }

    MaskPhoneNumber.prototype.enable = function() {
        var maskBehavior = function (val) {
            return val.replace(/\D/g, '').length === 11 ? '(00) 00000-0000' : '(00) 0000-00009';
        };

        var options = {
            onKeyPress: function(val, e, field, options) {
                field.mask(maskBehavior.apply({}, arguments), options);
            }
        };

        this.inputPhoneNumber.mask(maskBehavior, options);

    }

    return MaskPhoneNumber;

}());

$(function () {
    var maskMoney = new Index.MaskMoney();
    maskMoney.enable();

    var maskPhoneNumber = new Index.MaskPhoneNumber();
    maskPhoneNumber.enable();

});