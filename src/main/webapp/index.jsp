<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<link rel="stylesheet" href="/webjars/jquery/3.3.1/dist/jquery.min.js">
<script language="JavaScript"
        src="/webjars/github-com-agschwender-jquery-formatDateTime/1.1.6/jquery.formatDateTime.js"></script>
<body>
<h2>Hello World!</h2>
<input type="text" id="test"><button id="btn">check</button>
<link rel="stylesheet" href="/webjars/github-com-fex-team-webuploader/0.1.5/dist/webuploader.css">
<script language="JavaScript"
        src="/webjars/tinymce/4.7.9/tinymce.min.js"></script>
<script language="JavaScript"
        src="/webjars/editor.md/1.5.0/editormd.js"></script>
<link rel="stylesheet" href="/webjars/font-awesome/4.7.0/css/font-awesome.css">

<form:form></form:form>

<script language="JavaScript">
    $(function () {
        $("#btn").click(function () {
            var re = new RegExp(/[0-1]\d+\.\d{2, 2}/);
            re.test($("#test").val());
        });
    });
</script>

</body>
</html>
