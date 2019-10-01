;(function (global,$) {

    function _getElements(formId) {
        var form = {};
        var t = $(formId).serializeArray();
        $.each(t, function () {
            form[this.name] = this.value;
        });
        form.usergender = $('#gender').val();
        form.userpower = $('#power').val();
        form = JSON.stringify(form);
        return form;
    }

    function _reset(from) {
        $(':input',from)
            .not(':button,:submit,:reset,:hidden')
            .val('')
            .removeAttr('checked')
            .removeAttr('selected');
    }

    var utils = {
        getElements : _getElements,
        reset : _reset
    }
    global.utils = utils;

})(window,$);