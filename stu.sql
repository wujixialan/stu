/*
Navicat MySQL Data Transfer

Source Server         : MariaDB
Source Server Version : 50505
Source Host           : localhost:3306
Source Database       : stu

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2018-05-26 11:24:24
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for clazz
-- ----------------------------
DROP TABLE IF EXISTS `clazz`;
CREATE TABLE `clazz` (
  `cid` varchar(60) NOT NULL COMMENT '班级编号',
  `clazzName` varchar(20) DEFAULT NULL COMMENT '班级名',
  `college` varchar(20) DEFAULT NULL COMMENT '学院',
  `profess` varchar(30) DEFAULT NULL COMMENT '专业',
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of clazz
-- ----------------------------
INSERT INTO `clazz` VALUES ('101', '软件1403', '计算机学院', '软件工程');
INSERT INTO `clazz` VALUES ('102', '软件1402', '计算机学院', '软件工程');
INSERT INTO `clazz` VALUES ('103', '软件1401', '计算机学院', '软件工程');

-- ----------------------------
-- Table structure for info
-- ----------------------------
DROP TABLE IF EXISTS `info`;
CREATE TABLE `info` (
  `info_id` varchar(60) NOT NULL COMMENT '信息发布的id',
  `info_title` varchar(120) DEFAULT NULL COMMENT '信息标题',
  `info_content` text COMMENT '信息发布的内容',
  `info_time` date DEFAULT NULL COMMENT '信息发布的时间',
  `info_type` varchar(20) DEFAULT NULL,
  `info_user_id` varchar(60) DEFAULT NULL COMMENT '信息发布者的id',
  PRIMARY KEY (`info_id`),
  KEY `info_user_id` (`info_user_id`),
  CONSTRAINT `info_user_id` FOREIGN KEY (`info_user_id`) REFERENCES `user` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of info
-- ----------------------------
INSERT INTO `info` VALUES ('23bc1d00f91d44ea82e3ef1bdf41f9c7', 'HTML 5 Canvas', '<p><strong>canvas 元素用于在网页上绘制图形。</strong></p>\n\n<h2>什么是 Canvas？</h2>\n\n<p>HTML5 的 canvas 元素使用 JavaScript 在网页上绘制图像。</p>\n\n<p>画布是一个矩形区域，您可以控制其每一像素。</p>\n\n<p>canvas 拥有多种绘制路径、矩形、圆形、字符以及添加图像的方法。</p>\n\n<h2>创建 Canvas 元素</h2>\n\n<p>向 HTML5 页面添加 canvas 元素。</p>\n\n<p>规定元素的 id、宽度和高度：</p>\n\n<pre>\n&lt;canvas id=&quot;myCanvas&quot; width=&quot;200&quot; height=&quot;100&quot;&gt;&lt;/canvas&gt;</pre>\n\n<h2>通过 JavaScript 来绘制</h2>\n\n<p>canvas 元素本身是没有绘图能力的。所有的绘制工作必须在 JavaScript 内部完成：</p>\n\n<pre>\n&lt;script type=&quot;text/javascript&quot;&gt;\nvar c=document.getElementById(&quot;myCanvas&quot;);\nvar cxt=c.getContext(&quot;2d&quot;);\ncxt.fillStyle=&quot;#FF0000&quot;;\ncxt.fillRect(0,0,150,75);\n&lt;/script&gt;\n</pre>\n\n<p>JavaScript 使用 id 来寻找 canvas 元素：</p>\n\n<pre>\nvar c=document.getElementById(&quot;myCanvas&quot;);</pre>\n\n<p>然后，创建 context 对象：</p>\n\n<pre>\nvar cxt=c.getContext(&quot;2d&quot;); </pre>\n\n<p>getContext(&quot;2d&quot;) 对象是内建的 HTML5 对象，拥有多种绘制路径、矩形、圆形、字符以及添加图像的方法。</p>\n\n<p>下面的两行代码绘制一个红色的矩形：</p>\n\n<pre>\ncxt.fillStyle=&quot;#FF0000&quot;;\ncxt.fillRect(0,0,150,75); \n</pre>\n\n<p>fillStyle 方法将其染成红色，fillRect 方法规定了形状、位置和尺寸。</p>\n\n<h2>理解坐标</h2>\n\n<p>上面的 fillRect 方法拥有参数 (0,0,150,75)。</p>\n\n<p>意思是：在画布上绘制 150x75 的矩形，从左上角开始 (0,0)。</p>\n\n<p>如下图所示，画布的 X 和 Y 坐标用于在画布上对绘画进行定位。</p>\n', '2018-05-13', '主动公开', '201407040324');
INSERT INTO `info` VALUES ('37e6d680efde4383882f93aecfa9e837', '工作111', '<p>工作怎么样。</p>\n', '2018-04-03', '主动公开', '201407040324');
INSERT INTO `info` VALUES ('42c9d8a723904359a1a163c214ef4e7a', '/info/to/info发布标题', '<pre>\n/info/to/info发布标题</pre>\n\n<pre>\n/info/to/info发布标题</pre>\n\n<pre>\n/info/to/info发布标题7654546d5fdsf</pre>\n', '2018-04-28', '主动公开', '201407040324');
INSERT INTO `info` VALUES ('4c7ea59c6ccc4174a99abb91d34847ce', 'dsad', '<p>sdadsadsd</p>\n', '2018-04-28', '主动公开', '201407040324');
INSERT INTO `info` VALUES ('4d52b1f74fde4b49bfdc34f9ac72225b', '年后发挥地方', '<p>的好方法对双方都依法第三方4545</p>', '2018-05-13', '主动公开', '201407040324');
INSERT INTO `info` VALUES ('5e780d85b5594a2e9e731e148b5ef8a2', 'layui官网', '<pre>\n<code>/*\n * ======================================================================\n * See javadoc API for class org.thymeleaf.expression.Dates\n * ======================================================================\n */\n\n/*\n * Format date with the standard locale format\n * Also works with arrays, lists or sets\n */\n${#dates.format(date)}\n${#dates.arrayFormat(datesArray)}\n${#dates.listFormat(datesList)}\n${#dates.setFormat(datesSet)}\n\n/*\n * Format date with the ISO8601 format\n * Also works with arrays, lists or sets\n */\n${#dates.formatISO(date)}\n${#dates.arrayFormatISO(datesArray)}\n${#dates.listFormatISO(datesList)}\n${#dates.setFormatISO(datesSet)}\n\n/*\n * Format date with the specified pattern\n * Also works with arrays, lists or sets\n */\n${#dates.format(date, &#39;dd/MMM/yyyy HH:mm&#39;)}\n${#dates.arrayFormat(datesArray, &#39;dd/MMM/yyyy HH:mm&#39;)}\n${#dates.listFormat(datesList, &#39;dd/MMM/yyyy HH:mm&#39;)}\n${#dates.setFormat(datesSet, &#39;dd/MMM/yyyy HH:mm&#39;)}\n\n/*\n * Obtain date properties\n * Also works with arrays, lists or sets\n */\n${#dates.day(date)}                    // also arrayDay(...), listDay(...), etc.\n${#dates.month(date)}                  // also arrayMonth(...), listMonth(...), etc.\n${#dates.monthName(date)}              // also arrayMonthName(...), listMonthName(...), etc.\n${#dates.monthNameShort(date)}         // also arrayMonthNameShort(...), listMonthNameShort(...), etc.\n${#dates.year(date)}                   // also arrayYear(...), listYear(...), etc.\n${#dates.dayOfWeek(date)}              // also arrayDayOfWeek(...), listDayOfWeek(...), etc.\n${#dates.dayOfWeekName(date)}          // also arrayDayOfWeekName(...), listDayOfWeekName(...), etc.\n${#dates.dayOfWeekNameShort(date)}     // also arrayDayOfWeekNameShort(...), listDayOfWeekNameShort(...), etc.\n${#dates.hour(date)}                   // also arrayHour(...), listHour(...), etc.\n${#dates.minute(date)}                 // also arrayMinute(...), listMinute(...), etc.\n${#dates.second(date)}                 // also arraySecond(...), listSecond(...), etc.\n${#dates.millisecond(date)}            // also arrayMillisecond(...), listMillisecond(...), etc.\n\n/*\n * Create date (java.util.Date) objects from its components\n */\n${#dates.create(year,month,day)}\n${#dates.create(year,month,day,hour,minute)}\n${#dates.create(year,month,day,hour,minute,second)}\n${#dates.create(year,month,day,hour,minute,second,millisecond)}\n\n/*\n * Create a date (java.util.Date) object for the current date and time\n */\n${#dates.createNow()}\n\n${#dates.createNowForTimeZone()}\n\n/*\n * Create a date (java.util.Date) object for the current date (time set to 00:00)\n */\n${#dates.createToday()}\n\n${#dates.createTodayForTimeZone()}</code></pre>\n', '2018-04-27', '主动公开', '201407040324');
INSERT INTO `info` VALUES ('6246bfe0c6ab41acb7a9f12aa258e309', '发布标题', '<p>发布标题发布标题发布标题的师傅的说法</p>\n', '2018-04-27', '主动公开', '201407040324');
INSERT INTO `info` VALUES ('9e0e01cbec6f446c827da889da19fc12', 'tinymce介绍', '<p>初始化<br />\n<br />\n在初始化TinyMCE的时候，需要把以下代码加入到页面的HEAD标签中。按以下例子中的设置，所有的TEXTAREA文本域在页面加载时将被转换成编辑器。另外还有其他模块，我们将在后面详细讲述。<br />\n&nbsp;</p>\n\n<table border=\"0\" cellpadding=\"2\" cellspacing=\"3\">\n	<tbody>\n		<tr>\n			<td>&lt;!-- tinyMCE --&gt;<br />\n			<br />\n			&lt;script language=&quot;javascript&quot; type=&quot;text/javascript&quot; src=&quot;jscripts/tiny_mce/tiny_mce.js&quot;&gt;&lt;/script&gt;<br />\n			<br />\n			&lt;script language=&quot;javascript&quot; type=&quot;text/javascript&quot;&gt;<br />\n			<br />\n			tinyMCE.init({<br />\n			<br />\n			mode : &quot;textareas&quot;<br />\n			<br />\n			});<br />\n			<br />\n			&lt;/script&gt;<br />\n			<br />\n			&lt;!-- /tinyMCE --&gt;</td>\n		</tr>\n	</tbody>\n</table>\n\n<p><br />\n<br />\n注意以上红色部分是tiny_mce.js脚本文件的位置，该文件中包含了编辑器所需要的全部代码，主题及语言包将在初始化时被加载。<br />\n<br />\n蓝色部分是初始化调用，它生成TinyMCE的全局实例，其中的设置及名称－值属性将在以后描述。<br />\n<br />\n<br />\n<br />\n设置<br />\n<br />\n<br />\n<br />\n以名称－值属性方式传递给tinyMCE的init方法的设置控制着程序的全局行为。所有的键及可能的键值如下表所示。注意，用[]括起来的名称是可选的，不是必须的设置。</p>\n\n<table border=\"0\" cellpadding=\"5\" cellspacing=\"1\" style=\"width:650px\">\n	<tbody>\n		<tr>\n			<td colspan=\"2\"><strong>常规设置</strong></td>\n		</tr>\n		<tr>\n			<td><strong>mode</strong></td>\n			<td>Mode可以是以下几个值之一：<br />\n			<br />\n			<br />\n			<br />\n			<strong>textareas</strong>&nbsp;- 页面加载时把所有TEXTAREA组件转换成编辑器.<br />\n			<br />\n			<strong>specific_textareas</strong>&nbsp;- 将所有&quot;mce_editable&quot;属性值为true的TEXTAREA转换成编辑器.<br />\n			<br />\n			<strong>exact</strong>&nbsp;- 只转换在&quot;elements&quot;设置中指定的确切组件.</td>\n		</tr>\n		<tr>\n			<td><strong>[theme]</strong></td>\n			<td>指定要使用的主题名称，主题将被放在TinyMCE的themes目录下，默认为default。TinyMCE自带三个内置的主题，它们是simple，default和advanced。<br />\n			<br />\n			如果你想创建自己的主题，请仔细阅读文档的&nbsp;<a href=\"http://milo.core-systems.de/~stepan/tiny/tinymce/docs/zh_cn/themes.htm\">主题</a>部分。</td>\n		</tr>\n		<tr>\n			<td><strong>[plugins]</strong></td>\n			<td>此选项是一系列以逗号分隔的主题插件列表（例如，可以只用来扩展图像对话框）。这些插件覆盖了主题模板中定义的功能。插件逻辑应该包含在一个叫&quot;editor_plugin.js&quot;的文件中，它是插件目录中唯一被包含进来的文件。<br />\n			<br />\n			例如：&quot;my_image_dialog,my_link_dialog&quot;.&nbsp;<br />\n			<br />\n			如果你想创建自己的插件，请仔细阅读文档的&nbsp;<a href=\"http://milo.core-systems.de/~stepan/tiny/tinymce/docs/zh_cn/themes.htm\">主题</a>部分。</td>\n		</tr>\n		<tr>\n			<td><strong>[language]</strong></td>\n			<td>TinyMCE中使用的语言包，这应该是像se,uk,us等诸如此类的FN代码，它被用来从&quot;langs&quot;目录中获取语言包，该设置的默认值为&quot;uk&quot;.<br />\n			<br />\n			中文用户建议您使用&quot;zh-CN&quot;</td>\n		</tr>\n		<tr>\n			<td><strong>[elements]</strong></td>\n			<td>以逗号分隔的用来转换成编辑器的组件列表，该选项仅在&quot;mode&quot;选项被设置成&quot;exact&quot;时使用。该列表中的元素可以是任何有id或name属性的HTML组件。</td>\n		</tr>\n		<tr>\n			<td><strong>[ask]</strong></td>\n			<td>当&quot;mode&quot;被设置成&quot;textareas&quot;或&quot;specific_textareas&quot;的时候，该选项被应用，询问用户输入框是否将被转换成编辑器。&nbsp;<br />\n			<br />\n			如果你想使用这个选项，将它设置为true.</td>\n		</tr>\n		<tr>\n			<td><strong>[textarea_trigger]</strong></td>\n			<td>textarea（文本域）触发器的属性，默认值为&quot;mce_editable&quot;。<br />\n			<br />\n			该选项仅在&quot;mode&quot;被设置为&quot;specific_textareas&quot;时使用。</td>\n		</tr>\n		<tr>\n			<td><strong>[valid_elements]</strong></td>\n			<td>以逗号分隔开的组件转换部分的列表。<br />\n			<br />\n			<br />\n			<br />\n			例如： a[href|target=_blank],strong/b,div[align],br.<br />\n			<br />\n			<br />\n			<br />\n			以上例子告诉TinyMCE移除所有除了&quot;a, strong, div&quot;和&quot;br&quot;的组件，将元素b转换成strong，默认target设为&quot;_blank&quot;并保持href、target、align属性。在匹配组件及属性的名称时可以使用像*,+,?这样的通配符。<br />\n			<br />\n			<br />\n			<br />\n			<strong>字符：</strong><br />\n			&nbsp;\n			<table border=\"0\" cellpadding=\"3\" cellspacing=\"0\">\n				<tbody>\n					<tr>\n						<td>,</td>\n						<td>各组件定义之间的分隔符。</td>\n					</tr>\n					<tr>\n						<td>/</td>\n						<td>两个同义组件之间的分隔符。第一个组件是会被用来输出的那个（即第二个组件被第一个替换）。</td>\n					</tr>\n					<tr>\n						<td>|</td>\n						<td>各属性定义之间的分隔符。</td>\n					</tr>\n					<tr>\n						<td>[</td>\n						<td>定义某组件的属性列表的开始符号。</td>\n					</tr>\n					<tr>\n						<td>]</td>\n						<td>定义某组件的属性列表的结束符号。</td>\n					</tr>\n					<tr>\n						<td>=</td>\n						<td>将属性的默认值设为特定值。例如：&quot;target=_blank&quot;</td>\n					</tr>\n					<tr>\n						<td>:</td>\n						<td>将属性的值强行设为特定值。例如：&quot;border:0&quot;</td>\n					</tr>\n					<tr>\n						<td>&lt;</td>\n						<td>校验某个属性的值。例如：&quot;target&lt;_blank?_self&quot;</td>\n					</tr>\n					<tr>\n						<td>?</td>\n						<td>属性校验值之间的分隔符，见上。</td>\n					</tr>\n				</tbody>\n			</table>\n			<br />\n			<br />\n			<strong>特殊变量：</strong><br />\n			<br />\n			{$uid} - 产生一个唯一ID号。 例如：&quot;p[id:{$uid}]&quot;.<br />\n			<br />\n			<br />\n			<br />\n			此选项的默认值是以下模式：<br />\n			<br />\n			&quot;a[href|target],strong/b[class],em/i[class],strike[class],u[class],p[class|align],ol,ul,li,br,<br />\n			<br />\n			img[class|src|border=0|alt|hspace|vspace|width|height|align],sub,sup,blockquote[dir|style],<br />\n			<br />\n			table[border=0|cellspacing|cellpadding|width|height|class|align],tr[rowspan],<br />\n			<br />\n			td[colspan|rowspan|width|height],div[class|align],span[class|align],pre[class|align],<br />\n			<br />\n			address[class|align],h1[class|align],h2[class|align],h3[class|align],<br />\n			<br />\n			h4[class|align],h5[class|align],h6[class|align],hr&quot;.<br />\n			<br />\n			<br />\n			<br />\n			要包含所有组件及属性，请使用 *[*] ，这在使用invalid_elements选项时特别有用。</td>\n		</tr>\n		<tr>\n			<td><strong>[extended_valid_elements]</strong></td>\n			<td>向&quot;valid_elements&quot;列表末尾添加可用组件。此选项在你仅仅想往默认列表中增添部分组件时相当有用。<br />\n			<br />\n			格式与&quot;valid_elements&quot;一致。</td>\n		</tr>\n		<tr>\n			<td><strong>[invalid_elements]</strong></td>\n			<td>输出时需要排除在外的组件名称列表，以逗号分隔开。</td>\n		</tr>\n		<tr>\n			<td><strong>[trim_span_elements]</strong></td>\n			<td>True/False选项。如果设置为true，不需要的组件将被移除。默认值即为true。</td>\n		</tr>\n		<tr>\n			<td><strong>[verify_css_classes]</strong></td>\n			<td>True/False选项。如果设置为true，将会校验CSS的class属性。默认值即为true。</td>\n		</tr>\n		<tr>\n			<td><strong>[verify_html]</strong></td>\n			<td>True/False选项。代表着HTML内容是否需要校验。默认值为true。</td>\n		</tr>\n		<tr>\n			<td><strong>[urlconvertor_callback]</strong></td>\n			<td>当清理进程处理URL的时候调用的函数名。此函数必须遵从以下的格式：func(url, node, on_save) ，返回转换后的URL。此设置专为集成目的而设。参数url代表要转换的地址，node代表包含URL的那个节点，on_save是一个布尔值（在用户提交表单时为真）。</td>\n		</tr>\n		<tr>\n			<td><strong>[preformatted]</strong></td>\n			<td>True/False选项。如果设置为true，编辑器将把制表符（TAB）转换成缩进，除此外保持其他whitespace（空白字符、换行等）字符，就如同HTML标签中的PRE的效果。默认值为false。</td>\n		</tr>\n		<tr>\n			<td><strong>[insertlink_callback]</strong></td>\n			<td>当执行&quot;insertlink&quot;命令时调用的函数名。此函数获取选定链接的地址和目标，返回一个以&quot;href&quot;, &quot;target&quot;和 &quot;title&quot;为collection名称的数组。当使用新窗口时，为了兼容Mozilla，会在window.opener（弹出窗口的母窗口，译者注）上调用tinyMCE.insertLink。</td>\n		</tr>\n		<tr>\n			<td><strong>[insertimage_callback]</strong></td>\n			<td>当执行&quot;insertimage&quot;命令时调用的函数名。此函数获取选定图像的url并返回一个以src和alt为collection名称的数组。当使用新窗口时，为了兼容Mozilla，会在window.opener上调用tinyMCE.insertImage。<br />\n			<br />\n			函数格式：insertimage(src, alt, border, hspace, vspace, width, height, align, title, onmouseover, onmouseout, action).</td>\n		</tr>\n		<tr>\n			<td><strong>[setupcontent_callback]</strong></td>\n			<td>当编辑器初始化时调用的函数名。函数格式：setupContentCallback(editor_id, node)，其中editor_id是编辑器的id，node是编辑器所在的body组件节点。</td>\n		</tr>\n		<tr>\n			<td><strong>[save_callback]</strong></td>\n			<td>当执行triggerSave（触发保存）命令被调用时调用的函数名。函数格式：save(id, content, node)，如果有特定返回值，其值将会被加到HTML表单组件上。所以可以通过此函数来自定义用户转换逻辑。</td>\n		</tr>\n		<tr>\n			<td><strong>[docs_language]</strong></td>\n			<td>TinyMCE文档中使用的语言，这应该是像se,uk,us等诸如此类的FN代码，它被用来从&quot;&lt;theme&gt;/docs/&lt;lang&gt;&quot;目录中获取文档。 该选项的默认值跟language选项一致。</td>\n		</tr>\n		<tr>\n			<td><strong>[width]</strong></td>\n			<td>编辑器的宽度，它默认的宽度是原先被替换的组件宽度。</td>\n		</tr>\n		<tr>\n			<td><strong>[height]</strong></td>\n			<td>编辑器的高度，它默认的高度是原先被替换的组件高度。</td>\n		</tr>\n		<tr>\n			<td><strong>[content_css]</strong></td>\n			<td>编辑窗口中要使用的CSS文件，其路径应该跟页面相关。</td>\n		</tr>\n		<tr>\n			<td><strong>[popups_css]</strong></td>\n			<td>像插入链接和图片时的弹出窗口中使用的CSS文件，其路径应该跟页面相关。</td>\n		</tr>\n		<tr>\n			<td><strong>[editor_css]</strong></td>\n			<td>编辑器使用的CSS文件，其路径应该跟页面相关。</td>\n		</tr>\n		<tr>\n			<td><strong>[encoding]</strong></td>\n			<td>编辑器的输出编码，此选项目前只能为&quot;html&quot;或者空。如果设置为&quot;html&quot;，编辑器的输出将经过HTML编码处理。<br />\n			<br />\n			例如：&lt;将会变成&amp;lt;，依此类推。默认值是空。</td>\n		</tr>\n		<tr>\n			<td><strong>[debug]</strong></td>\n			<td>True/False选项。如果设置成true，像css文件路径等调试信息将会被显示。</td>\n		</tr>\n		<tr>\n			<td><strong>[visual]</strong></td>\n			<td>True/False选项。如果设置成true，当边框设置成0的时候，为达到更好的视觉效果在编辑器中表格会有虚线出现。<br />\n			<br />\n			默认值为true。</td>\n		</tr>\n		<tr>\n			<td><strong>[visual_table_style]</strong></td>\n			<td>用户可自定义表格的样式，默认值为：&quot;border: 1px dashed #BBBBBB&quot;。</td>\n		</tr>\n		<tr>\n			<td><strong>[add_form_submit_trigger]</strong></td>\n			<td>True/False选项。如果设置成true，将强制进行所有表单的&quot;onsubmit&quot;事件处理并引发保存。此选项默认值为true。</td>\n		</tr>\n		<tr>\n			<td><strong>[add_unload_trigger]</strong></td>\n			<td>True/False选项。如果设置成true，在&quot;onunload&quot;事件发生时，当前窗口会引发一个triggerSave调用。此triggerSave调用不会做任何清理工作，因为它是用来处理 前进/后退 按钮的。此选项默认值为true。</td>\n		</tr>\n		<tr>\n			<td><strong>[force_br_newlines]</strong></td>\n			<td>True/False选项。此选项强制编辑器将段落符号(P)替换成换行符(BR)。此选项默认值为false。（实验阶段）</td>\n		</tr>\n		<tr>\n			<td><strong>[force_p_newlines]</strong></td>\n			<td>True/False选项。如果打开此选项，在按下回车键（Enter）时Mozilla/Firefox浏览器会生成段落符号(P)，在按下Shift+Enter时会生成换行符(BR)。此选项默认为true。</td>\n		</tr>\n		<tr>\n			<td><strong>[relative_urls]</strong></td>\n			<td>True/False选项。如果设置成true，绝对路径将被转换成相对路径。默认值为true。</td>\n		</tr>\n		<tr>\n			<td><strong>[remove_script_host]</strong></td>\n			<td>True/False选项。在设置成true的情况下，如果URL中的主机名、端口号跟编辑器当前所在一致，它们会被移除。<br />\n			<br />\n			例如：编辑器所在站点为 http://www.somesite.com ，那么以下链接 http://www.somesite.com/somedir/somepage.html 将会被转换成 /somedir/somepage.html 。<br />\n			<br />\n			如果relative_urls被设置成false，此选项默认为true。</td>\n		</tr>\n		<tr>\n			<td><strong>[focus_alert]</strong></td>\n			<td>True/False选项。如果设置成true，编辑器在失去焦点的时候就会出现一个烦人的警告框。默认值为true。</td>\n		</tr>\n		<tr>\n			<td><strong>[document_base_url]</strong></td>\n			<td>在将绝对路径转换成相对路径的时候会用到此文档的URL。这个选项指定了编辑器当前的默认文档。<br />\n			<br />\n			注意如果此选项指定到一个域名，请添加协议前缀，并以斜杠结尾。例如：http://www.somehost.com/mydir/</td>\n		</tr>\n		<tr>\n			<td><strong>[custom_undo_redo]</strong></td>\n			<td>True/False选项。此选项可以使 撤消/重做 功能更加完善。默认值为true。</td>\n		</tr>\n		<tr>\n			<td><strong>[custom_undo_redo_levels]</strong></td>\n			<td>自定义最多可撤消操作的次数，默认是无限制。</td>\n		</tr>\n		<tr>\n			<td><strong>[custom_undo_redo_keyboard_shortcuts]</strong></td>\n			<td>如果使用，编辑器可以使用Ctrl+Z和Ctrl+Y快捷键来实现撤消和重做。默认允许。</td>\n		</tr>\n		<tr>\n			<td><strong>[fix_content_duplication]</strong></td>\n			<td>True/False选项。此选项修正了MSIE中一个内容重复的bug。默认启用，但是为了兼容性也可以禁用(false)。</td>\n		</tr>\n		<tr>\n			<td><strong>[directionality]</strong></td>\n			<td>此选项可以设置像阿拉伯语等语言的文字方向。可能的值为：ltr, rtl。默认值: ltr（从左到右）。</td>\n		</tr>\n		<tr>\n			<td><strong>[auto_cleanup_word]</strong></td>\n			<td>如果启用，从MS office/Word粘贴的HTML将会自动被清理。此选项默认值为false。<br />\n			<br />\n			注意：此操作当前仅支持MSIE。</td>\n		</tr>\n		<tr>\n			<td><strong>[cleanup_on_startup]</strong></td>\n			<td>如果启用，在编辑器初始化时文本域及组件将会被清理。默认值为false。</td>\n		</tr>\n		<tr>\n			<td><strong>[inline_styles]</strong></td>\n			<td>如果启用，像width,height,vspace,hspace和align等属性将会被风格属性替代。默认值为false。<br />\n			<br />\n			在使用此选项时记得要把风格属性应用在正确的组件上。</td>\n		</tr>\n		<tr>\n			<td><strong>[convert_newlines_to_brs]</strong></td>\n			<td>如果启用，所有的\\n(新行)将会在编辑器启动时被转换成&lt;br /&gt;组件。此选项默认值为false。</td>\n		</tr>\n		<tr>\n			<td><strong>[auto_reset_designmode]</strong></td>\n			<td>因为在调用style.display的none/block方法来显示/隐藏某个TinyMCE编辑器的时候有bug，设计模式需要被重置。此选项一旦启用，当编辑器聚焦时，将自动重置。默认值为false。</td>\n		</tr>\n		<tr>\n			<td><strong>[entities]</strong></td>\n			<td>一张以字符代码来查找名称的表，该表中元素是以逗号分隔开的实体列表。该列表以奇数项、偶数项区分，其中奇数项是被用来转换的字符代码，偶数项是代表那个字符代码的实体名称。例如：&quot;8205,zwj,8206,lrm,8207,rlm,173,shy&quot;。</td>\n		</tr>\n		<tr>\n			<td><strong>[cleanup_callback]</strong></td>\n			<td>自定义清理函数。此选项能让用户在默认的清理基础上有所扩展。此函数调用跟默认的调用是分开的，它并不替换默认的清理函数，而仅仅是扩展。点击&nbsp;<a href=\"http://milo.core-systems.de/~stepan/tiny/tinymce/docs/zh_cn/themes.htm#cleanup\">插件清理</a>&nbsp;查看更多细节。</td>\n		</tr>\n		<tr>\n			<td colspan=\"2\"><strong>主题的高级特定设置</strong></td>\n		</tr>\n		<tr>\n			<td><strong>[theme_advanced_toolbar_location]</strong></td>\n			<td>此选项用来改变工具栏的默认位置。可能的值为：&quot;top&quot;和&quot;bottom&quot;。默认值是&quot;bottom&quot;。</td>\n		</tr>\n		<tr>\n			<td><strong>[theme_advanced_toolbar_align]</strong></td>\n			<td>此选项用来设置工具栏的对齐方式是left, center还是right。默认值是center。</td>\n		</tr>\n		<tr>\n			<td><strong>[theme_advanced_styles]</strong></td>\n			<td>此选项可以用来增加风格下拉框中的CSS类和名称。格式如下：&quot;&lt;title&gt;=&lt;class&gt;;..&quot;。<br />\n			<br />\n			如果没有指定此选项，主内容部分的CSS类将会被自动导入。<br />\n			<br />\n			例如：&quot;Header 1=header1;Header 2=header2;Header 3=header3&quot;</td>\n		</tr>\n		<tr>\n			<td><strong>[theme_advanced_buttons1]</strong></td>\n			<td>工具栏上第一行要包含的按钮列表，以逗号分隔开。例如：&quot;bold,italic,underline&quot;。<br />\n			<br />\n			<br />\n			<br />\n			允许的按钮名称如下：<br />\n			<br />\n			bold, italic, underline, strikethrough, justifyleft, justifycenter, justifyright, justifyfull, styleselect, bullist, numlist, outdent, indent, undo,redo, link, unlink, image, cleanup, help, code, table, row_before, row_after, delete_row, separator, rowseparator, col_before, col_after, delete_col, hr, removeformat, sub, sup, formatselect, fontselect, fontsizeselect, forecolor,charmap,visualaid,spacer,cut,copy,paste</td>\n		</tr>\n		<tr>\n			<td><strong>[theme_advanced_buttons2]</strong></td>\n			<td>同上，差别在于指定的是工具栏第二行。</td>\n		</tr>\n		<tr>\n			<td><strong>[theme_advanced_buttons3]</strong></td>\n			<td>同上，差别在于指定的是工具栏第三行。</td>\n		</tr>\n		<tr>\n			<td><strong>[theme_advanced_buttons&lt;N&gt;_add]</strong></td>\n			<td>向工具栏上特定的第N行中增加额外的控制/按钮。例如：theme_advaned_buttons3_add : &quot;iespell&quot;.</td>\n		</tr>\n		<tr>\n			<td><strong>[theme_advanced_buttons&lt;N&gt;_add_before]</strong></td>\n			<td>向工具栏上特定的第N行的默认按钮前面增加额外的控制/按钮。例如：theme_advaned_buttons3_add_before : &quot;iespell&quot;。</td>\n		</tr>\n		<tr>\n			<td><strong>[theme_advanced_disable]</strong></td>\n			<td>要禁用的按钮/组件的列表，以逗号分隔。例如：&quot;formatselect&quot;.</td>\n		</tr>\n		<tr>\n			<td><strong>[theme_advanced_source_editor_width]</strong></td>\n			<td>源文件编辑器窗口的宽度。</td>\n		</tr>\n		<tr>\n			<td><strong>[theme_advanced_source_editor_height]</strong></td>\n			<td>源文件编辑器窗口的高度。</td>\n		</tr>\n		<tr>\n			<td><strong>[theme_advanced_path_location]</strong></td>\n			<td>组件路径列表的位置，可能的值为：&quot;top&quot;或&quot;bottom&quot;。默认值为：&quot;none&quot;</td>\n		</tr>\n		<tr>\n			<td><strong>[theme_advanced_blockformats]</strong></td>\n			<td>formatselect列表要屏蔽的格式列表，以逗号分隔开。默认值：p,address,pre,h1,h2,h3,h4,h5,h6。</td>\n		</tr>\n	</tbody>\n</table>\n', '2018-05-13', '主动公开', '201407040324');
INSERT INTO `info` VALUES ('b6eeef91a9f74e7c86eb4c46441ea0b4', '地方都是废话', '地方都是废话地方都是废话地方都是废话地方都是废话地方都是废45454545', '2018-05-13', '主动公开', '201407040324');
INSERT INTO `info` VALUES ('d83a80cfa77a40dd93143d9c45576c9a', '学习', '<p>学习怎么样。佛挡杀佛六点十分</p>\n', '2018-04-27', '主动公开', '201407040324');
INSERT INTO `info` VALUES ('d83a80cfa77a40dd93143d9csd576c9a', '看电影', '<p>想玩。</p>\n', '2018-04-28', '主动公开', '201407040324');
INSERT INTO `info` VALUES ('e1b3c885aec146839fec9a700b365cf7', 'layui介绍', '<p>layer 至今仍作为 layui 的代表作，她的受众广泛并非偶然，而是这数年来的坚持、不弃的执念，将那些不屑的眼光转化为应得的尊重，不断完善和维护、不断建设和提升社区服务，在 Web 开发者的圈子里口口相传，乃至于成为今天的 layui 最强劲的源动力。目前，<em>layer已成为国内最多人使用的 Web 弹层组件</em>，<a href=\"https://github.com/sentsin/layer\" target=\"_blank\">GitHub</a>&nbsp;自然Stars<em>5000+</em>，官网累计下载量达50w+，大概有30万不同规模的 Web 平台使用过 layer。&nbsp;<br />\n<br />\n之所以列举上面这些数字，并非是在夸夸其谈，而是懂 layer 的人都知道，这是一种怎样不易的沉淀。而由于 layer 在 layui 体系中的位置比较特殊，甚至让很多人都误以为 layui = layer ui，所以再次强调 layer 只是作为 layui 的一个弹层模块，由于其用户基数较大，所以至今仍把她作为独立组件来维护。不过请注意：无论是独立的 layer，还是作为内置模块的 layer，文档都以本页为准。</p>\n\n<p>&nbsp;</p>\n\n<ol>\n	<li>├─css //css目录</li>\n	<li>│ │─modules //模块css目录（一般如果模块相对较大，我们会单独提取，比如下面三个：）</li>\n	<li>│ │ ├─laydate</li>\n	<li>│ │ ├─layer</li>\n	<li>│ │ └─layim</li>\n	<li>│ └─layui.css //核心样式文件</li>\n	<li>├─font //字体图标目录</li>\n	<li>├─images //图片资源目录（目前只有layim和编辑器用到的GIF表情）</li>\n	<li>│─lay //模块核心目录</li>\n	<li>│ └─modules //各模块组件</li>\n	<li>│─layui.js //基础核心库</li>\n	<li>└─layui.all.js //包含layui.js和所有模块的合并文件</li>\n</ol>\n', '2018-05-09', '主动公开', '201407040324');

-- ----------------------------
-- Table structure for mark
-- ----------------------------
DROP TABLE IF EXISTS `mark`;
CREATE TABLE `mark` (
  `mark_id` varchar(60) NOT NULL,
  `subject_id` varchar(60) NOT NULL COMMENT '科目编号',
  `subject_name` varchar(30) DEFAULT NULL COMMENT '科目名称',
  `score` float(11,2) DEFAULT NULL COMMENT '成绩',
  `hang` varchar(5) DEFAULT NULL COMMENT '是否有挂科（1为挂科，0为未挂科）',
  `study` varchar(10) DEFAULT NULL COMMENT '是否初修？',
  `review` int(11) DEFAULT NULL,
  `subject_type` varchar(10) DEFAULT NULL COMMENT '科目类别',
  `team` varchar(50) DEFAULT NULL COMMENT '学期',
  `credit` float(11,1) DEFAULT NULL COMMENT '学分',
  `gpa` float(11,1) DEFAULT NULL COMMENT '绩点',
  `stu_id` varchar(60) DEFAULT NULL COMMENT '学生的学号',
  PRIMARY KEY (`mark_id`),
  KEY `m_stu_id` (`stu_id`),
  CONSTRAINT `m_stu_id` FOREIGN KEY (`stu_id`) REFERENCES `student` (`sid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of mark
-- ----------------------------
INSERT INTO `mark` VALUES ('07a35d8b611f4bdeb31f9f1c28fb32ff', 'm04', 'java', '80.00', '否', '初修', '0', '计算机', '2014-2015 第二学期', '3.0', '3.0', '201405060101');
INSERT INTO `mark` VALUES ('423764540465438aa6f1772745dd8d7d', 'm03', '数学', '45.00', '是', '初修', '0', '理科', '2014-2015 第二学期', '1.0', '0.0', '201202030102');
INSERT INTO `mark` VALUES ('42becba7fa0a4077bd8b2d8024935e62', 'm03', '数学', '55.00', '是', '补考', '0', '理科', '2014-2015 第二学期', '1.0', '0.0', '201405060102');
INSERT INTO `mark` VALUES ('4364ff4454cf4bd5a6e1fc974dfabeb6', 'm05', '数据结构', '44.00', '是', '初修', '0', '计算机', '2014-2015 第二学期', '4.0', '0.0', '201405060105');
INSERT INTO `mark` VALUES ('6b940709d87e4a4196f306ff72ae6872', 'm04', 'java', '72.00', '否', '初修', '0', '计算机', '2014-2015 第二学期', '3.0', '2.2', '201405060102');
INSERT INTO `mark` VALUES ('7ce3af7e5c514d89a3bf4766f9c8c69d', 'm02', '语文', '65.00', '否', '初修', '0', '文科', '2014-2015 第二学期', '1.5', '1.5', '201405060102');
INSERT INTO `mark` VALUES ('83e61fab4b894eaf90cd4181653ea410', 'm02', '语文', '90.00', '否', '初修', '0', '文科', '2014-2015 第二学期', '1.5', '4.0', '201202030102');
INSERT INTO `mark` VALUES ('87f3f68366ac4d2c8f82bfdab29c6000', 'm05', '数据结构', '69.00', '是', '补考', '0', '计算机', '2014-2015 第二学期', '4.0', '1.9', '201202030102');
INSERT INTO `mark` VALUES ('9acac24461a2494b8d9b70eb86b6cf24', 'm02', '语文', '60.00', '否', '初修', '0', '文科', '2014-2015 第二学期', '1.5', '1.0', '201405060105');
INSERT INTO `mark` VALUES ('9b1e1c6615df4218ba3fc8c955552400', 'm01', '英语', '55.00', '是', '初修', '0', '文科', '2014-2015 第二学期', '2.0', '0.0', '201405060101');
INSERT INTO `mark` VALUES ('aabf4d23b79e4d22af079f218fb2b984', 'm02', '语文', '70.00', '否', '初修', '0', '文科', '2014-2015 第二学期', '1.5', '2.0', '201405060101');
INSERT INTO `mark` VALUES ('b757416a94e64502876713f337d38bed', 'm04', 'java', '55.00', '是', '补考', '0', '计算机', '2014-2015 第二学期', '3.0', '0.0', '201202030102');
INSERT INTO `mark` VALUES ('bbfd48fbc8df46ffa15edfd9d6be2ea7', 'm03', '数学', '65.00', '否', '初修', '0', '理科', '2014-2015 第二学期', '1.0', '1.5', '201405060101');
INSERT INTO `mark` VALUES ('c9182ced4ed94ecdb7e4b7c38ce6cb66', 'm05', '数据结构', '84.00', '是', '补考', '0', '计算机', '2014-2015 第二学期', '4.0', '3.4', '201405060102');
INSERT INTO `mark` VALUES ('d8c715bc35d340b0afd83852ddb8a511', 'm01', '英语', '84.00', '是', '重修', '0', '文科', '2014-2015 第二学期', '2.0', '3.4', '201405060102');
INSERT INTO `mark` VALUES ('e1ee083553654f21a7cf83732826086a', 'm01', '英语', '60.00', '否', '初修', '0', '文科', '2014-2015 第二学期', '2.0', '1.0', '201202030102');
INSERT INTO `mark` VALUES ('f2f8d6efe57e4ef2bd04ca4e286775de', 'm01', '英语', '75.00', '是', '补考', '0', '文科', '2014-2015 第二学期', '2.0', '2.5', '201405060105');
INSERT INTO `mark` VALUES ('f3314346ed1c4bbb939c417f82e098b5', 'm04', 'java', '56.00', '是', '初修', '0', '计算机', '2014-2015 第二学期', '3.0', '0.0', '201405060105');
INSERT INTO `mark` VALUES ('f584fbd49ced4c9ea9ca8a1dc263a4e5', 'm05', '数据结构', '90.00', '否', '初修', '0', '计算机', '2014-2015 第二学期', '4.0', '4.0', '201405060101');
INSERT INTO `mark` VALUES ('f8ce2e407d63418a9fff531f0fd27901', 'm03', '数学', '90.00', '是', '重修', '0', '理科', '2014-2015 第二学期', '1.0', '4.0', '201405060105');

-- ----------------------------
-- Table structure for review
-- ----------------------------
DROP TABLE IF EXISTS `review`;
CREATE TABLE `review` (
  `review_id` varchar(60) NOT NULL COMMENT '申请id',
  `review_content` text COMMENT '申请内容',
  `mark_id` varchar(60) NOT NULL COMMENT '成绩id',
  `stu_id` varchar(60) NOT NULL COMMENT '学生学号',
  PRIMARY KEY (`review_id`),
  KEY `review_mark_id` (`mark_id`),
  KEY `review_stu_id` (`stu_id`),
  CONSTRAINT `review_mark_id` FOREIGN KEY (`mark_id`) REFERENCES `mark` (`mark_id`),
  CONSTRAINT `review_stu_id` FOREIGN KEY (`stu_id`) REFERENCES `student` (`sid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of review
-- ----------------------------

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `sid` varchar(60) NOT NULL COMMENT '学号',
  `name` varchar(50) DEFAULT NULL COMMENT '姓名',
  `gender` varchar(3) DEFAULT NULL COMMENT '性别',
  `nation` varchar(20) DEFAULT NULL COMMENT '民族',
  `origin` varchar(20) DEFAULT NULL COMMENT '籍贯',
  `birth` date DEFAULT NULL COMMENT '出生年月',
  `idCard` varchar(18) DEFAULT NULL COMMENT '身份证号',
  `address` varchar(30) DEFAULT NULL COMMENT '家庭住址',
  `photo` varchar(120) DEFAULT NULL COMMENT '照片URL',
  `review_id` int(11) DEFAULT NULL COMMENT '反馈标识',
  `review_content` varchar(255) DEFAULT NULL COMMENT '反馈内容',
  `clazzId` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`sid`),
  KEY `clazzId` (`clazzId`),
  CONSTRAINT `clazzId` FOREIGN KEY (`clazzId`) REFERENCES `clazz` (`cid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('201202030102', '费米', '女', '中国', '中国四川成都', '1992-06-25', '610121199206250231', '中国四川成都', null, '0', '学生未审核', '103');
INSERT INTO `student` VALUES ('201301020302', '夏哲生', '女', '中国', '陕西西安', '2018-05-14', '610222201805140102', '陕西省西安市', null, '0', '学生未审核', '103');
INSERT INTO `student` VALUES ('201405060101', '小王', '女', '德国', '德国汉堡', '1990-03-15', '71012419900315020X', '德国汉堡', null, '0', '学生未审核', '102');
INSERT INTO `student` VALUES ('201405060102', '赵小名', '男', '美国', '美国洛杉矶', '1992-06-25', '21001019920625010x', '美国洛杉矶', null, '0', '学生未审核', '103');
INSERT INTO `student` VALUES ('201405060105', '陆运', '男', '德国', '德国汉堡', '1992-06-25', '710124199206250112', '德国汉堡', null, '0', '学生未审核', '102');
INSERT INTO `student` VALUES ('201505060102', '小明', '男', '美国', '美国纽约', '1990-04-02', '210012199004020123', '美国纽约', null, '0', '学生未审核', '102');
INSERT INTO `student` VALUES ('201505060103', '小浩', '男', '中国', '中国上海', '1985-02-02', '610125198502020101', '中国上海', null, '0', '学生未审核', '103');
INSERT INTO `student` VALUES ('201505060104', '小马', '女', '日本', '日本东京', '1986-01-02', '410132198601020103', '日本东京', null, '0', '学生未审核', '101');
INSERT INTO `student` VALUES ('201505060105', '小云', '男', '韩国', '韩国首尔', '1980-09-01', '510195198009010223', '韩国首尔', null, '0', '学生未审核', '103');
INSERT INTO `student` VALUES ('201505060108', '李铭', '女', '日本', '日本东京', '1991-03-02', '410132199103020206', '日本东京', null, '0', '学生未审核', '101');
INSERT INTO `student` VALUES ('201505060109', '赵云', '男', '美国', '美国纽约', '1996-12-02', '210012199612020130', '美国纽约', null, '0', '学生未审核', '101');
INSERT INTO `student` VALUES ('201505060110', '赵宇', '女', '中国', '中国北京', '1996-12-02', '610123199612020220', '中国北京', null, '0', '学生未审核', '103');
INSERT INTO `student` VALUES ('201505060111', '张佳', '女', '日本', '日本东京', '1992-06-25', '410132199206250204', '日本东京', null, '0', '学生未审核', '101');
INSERT INTO `student` VALUES ('201505060112', '赵雪', '男', '美国', '美国洛杉矶', '1996-12-02', '210010199612020106', '美国洛杉矶', null, '0', '学生未审核', '101');
INSERT INTO `student` VALUES ('201505060115', '卢娜', '女', '美国', '美国洛杉矶', '1996-12-02', '210010199612020235', '美国洛杉矶', null, '0', '学生未审核', '101');
INSERT INTO `student` VALUES ('201505060116', '小米', '女', '韩国', '韩国首尔', '1990-12-25', '51019519901225020X', '韩国首尔', null, '0', '学生未审核', '103');
INSERT INTO `student` VALUES ('201505060117', '小娜', '男', '中国', '中国陕西西安', '1990-04-02', '610222199004020103', '中国陕西西安', null, '0', '学生未审核', '102');
INSERT INTO `student` VALUES ('201505060118', '小鱼', '女', '中国', '中国浙江杭州', '1985-02-02', '610021198502020209', '中国浙江杭州', null, '0', '学生未审核', '101');
INSERT INTO `student` VALUES ('201505060119', '小雪', '男', '德国', '德国汉堡', '1986-01-02', '710124198601020107', '德国汉堡', null, '0', '学生未审核', '102');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userId` varchar(60) NOT NULL COMMENT '用户id(如教师代码，学号，管理员id等)',
  `username` varchar(30) DEFAULT NULL COMMENT '用户姓名',
  `password` varchar(60) DEFAULT NULL COMMENT '用户密码',
  `userType` varchar(20) DEFAULT NULL COMMENT '登录的用户类型',
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('201202030102', '费米', 'e4e348cd96d068f8e6de856512ee6207', '学生');
INSERT INTO `user` VALUES ('201203010220', '侠岚', 'e4e348cd96d068f8e6de856512ee6207', '教师');
INSERT INTO `user` VALUES ('201404070325', 'xialan', 'e4e348cd96d068f8e6de856512ee6207', '管理员');
INSERT INTO `user` VALUES ('201405060102', '小李', 'e4e348cd96d068f8e6de856512ee6207', '学生');
INSERT INTO `user` VALUES ('201407040324', '无极侠岚', 'e4e348cd96d068f8e6de856512ee6207', '管理员');
INSERT INTO `user` VALUES ('201505060103', '小浩', 'e4e348cd96d068f8e6de856512ee6207', '学生');
INSERT INTO `user` VALUES ('201505060105', 'fdkds放大看电视', 'e4e348cd96d068f8e6de856512ee6207', '学生');
INSERT INTO `user` VALUES ('201703020356', '辗迟', 'e4e348cd96d068f8e6de856512ee6207', '教师');
