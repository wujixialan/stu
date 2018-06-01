/**
 * @license Copyright (c) 2003-2017, CKSource - Frederico Knabben. All rights reserved.
 * For licensing, see LICENSE.md or http://ckeditor.com/license
 */

CKEDITOR.editorConfig = function (config) {
    // Define changes to default configuration here. For example:
    // config.language = 'fr';
    // config.uiColor = '#AADC6E';
    config.height = 300;
    config.language = 'zh-cn';
    config.resize_enabled = false;
    config.filebrowserImageUploadUrl = '/stu/info/uploadImg'; //注意此处由于浏览器内核不同，路径有些许不同。
    config.image_previewText = ' 预览内容，此处设为空';
    config.toolbar =
        [
            //加粗     斜体，     下划线      穿过线      下标字        上标字
            ['Bold', 'Italic', 'Underline', 'Strike', 'Subscript', 'Superscript'],
            // 数字列表          实体列表            减小缩进    增大缩进
            ['NumberedList', 'BulletedList', '-', 'Outdent', 'Indent'],
            //左对 齐             居中对齐          右对齐          两端对齐
            ['JustifyLeft', 'JustifyCenter', 'JustifyRight', 'JustifyBlock'],
            //超链接  取消超链接 锚点
            ['Link', 'Unlink', 'Anchor'],
            //图片    flash    表格       水平线           表情符号   特殊字符        分页符
            ['Image', 'Table', 'HorizontalRule', "Smiley", 'SpecialChar', 'PageBreak'],
            // 样式      格式    字体    字体大小
            ['Styles', 'Format', 'Font', 'FontSize'],
            //文本颜色     背景颜色
            ['TextColor', 'BGColor'],
            //打印        拼写检查     即时拼写检查 撤销   重做
            ["Print", "SpellChecker", "Scayt", "Undo", "Redo"],

        ];
    config.smiley_path = "/stu/plugins/smiley/images/";
    config.smiley_images = [
        '1.png', 'angel_smile.gif', 'angry_smile.gif',
        'broken_heart.gif', 'confused_smile.gif', 'cry_smile.gif',
        'devil_smile.gif', 'embaressed_smile.gif', 'embarrassed_smile.gif',
        'envelope.gif', 'heart.gif', 'kiss.gif', 'lightbulb.gif', 'omg_smile.gif',
        'regular_smile.gif', 'sad_smile.gif', 'shades_smile.gif', 'teeth_smile.gif',
        'thumbs_down.gif', 'thumbs_up.gif', 'tongue_smile.gif', 'tounge_smile.gif',
        'whatchutalkingabout_smile.gif', 'wink_smile.gif'
    ];
    //添加中文字体
    config.font_names = "宋体/SimSun;新宋体/NSimSun;仿宋_GB2312/FangSong_GB2312;楷体_GB2312/KaiTi_GB2312;黑体/SimHei;微软雅黑/Microsoft YaHei;幼圆/YouYuan;华文彩云/STCaiyun;华文行楷/STXingkai;方正舒体/FZShuTi;方正姚体/FZYaoti;" + config.font_names;

};
