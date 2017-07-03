/*
Navicat MySQL Data Transfer

Source Server         : connection
Source Server Version : 50624
Source Host           : localhost:3306
Source Database       : easybuy

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2017-06-26 23:02:48
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `easybuy_cart`
-- ----------------------------
DROP TABLE IF EXISTS `easybuy_cart`;
CREATE TABLE `easybuy_cart` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `eu_userid` varchar(20) NOT NULL,
  `ep_id` int(10) NOT NULL,
  `ep_quantity` int(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of easybuy_cart
-- ----------------------------
INSERT INTO `easybuy_cart` VALUES ('13', 'kobe', '3', '1');
INSERT INTO `easybuy_cart` VALUES ('20', 'kobe', '2', '1');
INSERT INTO `easybuy_cart` VALUES ('49', 'arg', '4', '1');
INSERT INTO `easybuy_cart` VALUES ('52', 'mark', '8', '1');

-- ----------------------------
-- Table structure for `easybuy_comment`
-- ----------------------------
DROP TABLE IF EXISTS `easybuy_comment`;
CREATE TABLE `easybuy_comment` (
  `ec_id` int(11) NOT NULL AUTO_INCREMENT,
  `ec_content` varchar(200) NOT NULL,
  `ec_create_time` date NOT NULL,
  `ec_reply` varchar(200) DEFAULT NULL,
  `ec_reply_time` date DEFAULT NULL,
  `ec_nick_name` varchar(10) NOT NULL,
  PRIMARY KEY (`ec_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of easybuy_comment
-- ----------------------------
INSERT INTO `easybuy_comment` VALUES ('1', '我的货发了没？', '2015-10-12', '已经发了11', '2015-10-13', '张三');
INSERT INTO `easybuy_comment` VALUES ('2', '宝贝不错了，谢谢店家', '2015-11-12', '谢谢亲的支持哦', '2015-12-16', '你信我也叫张三吗');
INSERT INTO `easybuy_comment` VALUES ('3', '兄台，我的货什么时候到？', '2015-12-01', '太哥，快到喽', '2015-12-02', '小孩游神');
INSERT INTO `easybuy_comment` VALUES ('4', '掌柜的，货呢？？？', '2015-12-14', '老大，小的早就准备好了，马上给你', '2015-12-14', '江湖最后一个大佬');
INSERT INTO `easybuy_comment` VALUES ('5', '货色不错，给个好评', '2015-12-17', '好人啊', '2015-12-17', '好人');
INSERT INTO `easybuy_comment` VALUES ('6', '你的货和我的ID很配，我很很中意', '2015-12-18', '不愧是文人雅士', '2015-12-18', '清雪');
INSERT INTO `easybuy_comment` VALUES ('7', '差品，坑B', '2015-12-18', '天地良心啊，我们的商品绝对物超所值，有什么不好的地方可以回复我们，我们将尽快的给你答复', '2015-12-18', '全世界的敌人');
INSERT INTO `easybuy_comment` VALUES ('8', '一般般', '2015-12-20', '我们将尽一个可能满足顾客的要求，有什么不足的地方欢迎顾客提出', '2015-12-20', '我才是真张三');
INSERT INTO `easybuy_comment` VALUES ('9', '我其实是来看小弟的', '2015-12-20', '祝你们兄弟幸福美满', '2015-12-20', '张三的大哥张四');

-- ----------------------------
-- Table structure for `easybuy_news`
-- ----------------------------
DROP TABLE IF EXISTS `easybuy_news`;
CREATE TABLE `easybuy_news` (
  `en_id` int(11) NOT NULL AUTO_INCREMENT,
  `en_title` varchar(100) NOT NULL DEFAULT '',
  `en_content` varchar(10000) NOT NULL DEFAULT '',
  `en_create_time` date DEFAULT NULL,
  PRIMARY KEY (`en_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of easybuy_news
-- ----------------------------
INSERT INTO `easybuy_news` VALUES ('1', '小岛秀夫成立新工作室', '<p>12月16日，小岛秀夫正式宣布从Konami离职，随后即公布了新工作室&ldquo;Kojima Productions&rdquo;的成立，同时将与索尼游戏达成合作协议，首款作品将由PS4主机独占。</p>\r\n\r\n<p>&nbsp;</p>\r\n\r\n<p>新工作室的LOGO如上图所示，小岛之后在推特上具体解释了其含义，设计中包含了中世纪骑士造型和太空时代的宇航服两者融合后的概念，表达了凭借最新技术和开创性的精神以新世界为目标的愿景。而设计这一LOGO的正是MGS系列的御用画师新川洋司，很显然他也追随小岛一起离开，成为了新工作室的成员，由此可以料想原小岛组的大部分主力成员都会在其旗下开创新事业。</p>\r\n\r\n<p>&nbsp;</p>\r\n\r\n<p>对于小岛秀夫和索尼游戏合作一事，业内人士也纷纷对此表示祝贺，SCE方面吉田修平当然就是首批庆祝的人士之一</p>\r\n', '2015-11-02');
INSERT INTO `easybuy_news` VALUES ('3', '春运火车票破亿张', '<p>据新华社电 记者从中国铁路总公司获悉，自11月26日铁路春运售票工作启动以来，截至12月15日，铁路部门共发售火车票1.7亿张，其中，通过12306网站发售车票突破1亿张，已占到售票总量60%。</p>\r\n\r\n<p>16日，铁路部门迎来节后返程车票发售高峰，开始发售2月13日（正月初六）图定旅客列车车票，同时提前40天开始发售春运增开旅客列车的车票。</p>\r\n\r\n<p>自2011年推出网络购票以来，12306网站累计发售火车票35亿张，方便了广大旅客出行。目前，12306网站运行平稳，售票秩序良好，旅客购票体验不断改善。</p>\r\n', '2015-11-12');
INSERT INTO `easybuy_news` VALUES ('4', '腾讯收购Riot Games剩余股权', '<p>日前，《英雄联盟》开发商Riot Games在官方博客发表声明，称公司为了采取更灵活的激励政策，已由腾讯收购了剩余股权。</p>\r\n\r\n<p><strong>官方声明原文如下：</strong></p>\r\n\r\n<p>&nbsp;</p>\r\n\r\n<p>为了感谢员工们一直以来的贡献， Riot决定将原本的股权激励计划做相应的调整。</p>\r\n\r\n<p>随着业务的发展和环境的变化，Riot将对结构进行调整以表彰并奖励员工们的贡献，首先变化的就是现有的股权方案。Riot的主要投资者腾讯最近购买了公司的剩余股权，这让公司在与员工们共享成功果实的同时，激励方案也将从股权奖励计划转变为现金奖励计划，所有员工将享有具有高竞争力的薪酬、开放的带薪休假制度、各种学习和发展项目、401K退休计划，以及医疗补贴计划等等。</p>\r\n\r\n<p>Riot将会用灵活的政策吸引并留住游戏人才，成为最适合工作的伟大公司。</p>\r\n\r\n<p>此前，在2008年，腾讯投资Riot Games获得22.34%的股权；2011年11月，腾讯花费2.31亿美元增持股权，持股比例达到92.78%。</p>\r\n', '2015-12-12');
INSERT INTO `easybuy_news` VALUES ('5', 'iPhone5/5S偷跑流量！', '<p>前一段时间，偷跑流量问题在国内引发广泛关注和争议，但老实说，大部分都是用户对手机管理不严，让一些恶意应用为所欲为。</p>\r\n\r\n<p>说到这里，很多人尤其是果粉同学可能要说Android系统如何如何了，但其实，苹果在这方面同样有问题，而且是苹果自己的问题，还故意隐瞒。</p>\r\n\r\n<p><strong>美国消费者权益保护律师事务所Hagens Berman代表广大的iPhone 5、iPhone 5S用户，向苹果提起了集体诉讼，原因是苹果明明知道这两款手机在AT&amp;T网络内，本已连接Wi-Fi的情况下，还会消耗LTE数据流量。</strong></p>\r\n\r\n<p>其实早在2012年9月的时候，一些iPhone 5用户就<a href=\"http://m.163.com/android/software/2vnl2f.html\" target=\"_blank\">发现</a>了这个Bug，自己的流量莫名其妙增多了。</p>\r\n\r\n<p>随后，苹果和Verizon称已经修复此问题，Verizon也确认受影响用户被偷跑的流量不会收费。</p>\r\n\r\n<p>但是据Hagens Berman调查发现，<strong>AT&amp;T版其实也有此问题，而且苹果和AT&amp;T都知道，却从来没有去修复，而且直到iOS 7、iPhone 5S发布，苹果都没有解决它。</strong></p>\r\n\r\n<p>据悉，该问题主要发生在用户长时间观看在线视频的时候，比如10-20分钟，此时GPU接管了所有的视频编码、解码、显示工作，完全清闲的CPU就自动休眠了，但这会导致Wi-Fi网络随时关闭，开始走数据流量，但系统却没有任何提示。</p>\r\n', '2015-12-03');
INSERT INTO `easybuy_news` VALUES ('7', 'SpaceX成功回收一级火箭', '12月22日消息，据TheVerge报道，SpaceX当日成功发射了迄今最强大的猎鹰9（Falcon 9）火箭。该火箭搭载了电信公司Orbcomm的11颗卫星进入预定轨道。随后该火箭成功在佛罗里达州卡纳维拉尔角发射基地笔直降落在地面上。 这是SpaceX公司首次成功回收猎鹰9火箭，过去的1年里该公司一直试图这么做但都未成功。这是朝实现火箭的可重复使用迈出了重要的第一步。这次发射也是SpaceX从6月猎鹰9号火箭为国际空间站运送物质时发生爆炸后首次发射。 现在这次往返飞行任务创造了历史——此前无人可以像猎鹰9号火箭一样，在深入太空后重返地球并成功着陆。不过，这不是垂直发射的火箭第一次在升空后笔直着陆。11月杰夫·贝索斯的私营太空发射公司蓝色起源（Blue Origin）宣布，New Shepard火箭在发射后成功回收。但猎鹰9号比New Shepard更复杂：发射高度更高、速度更快。', '2015-12-01');
INSERT INTO `easybuy_news` VALUES ('8', '11月手游网易iOS收入全球第一', '<p>这次的全球iOS开发商收入榜变动最大，比如前五名除了Machine Zone仍居第四名之外，其余全部发生了变化。凭借今年3月底发布的《梦幻西游》以及9月初发布的《大话西游》两款MMO手游，再加上《<a href=\"http://ka.play.163.com/shouyou/apple/14471/\" target=\"_blank\">乖离性百万亚瑟王</a>》等手游的帮助，网易终于首次拿下了全球iOS收入冠军的地位。</p>\r\n\r\n<p><strong>《梦幻西游》全球前二</strong></p>\r\n\r\n<p>在收入榜方面，日本手游首次没有出现在前三名当中，凭借在美国、日本以及多个地区的大力推广，《战争游戏》在11月保住了iOS收入榜冠军的地位，网易的《梦幻西游》则延续了一直以来的强势表现，并且在11月推出了首部新资料片，推动了该游戏的收入增长，进入iOS收入榜前二。</p>\r\n\r\n<p>除此之外，网易的《大话西游》也进入到了收入榜前7。</p>\r\n', '2015-12-15');
INSERT INTO `easybuy_news` VALUES ('9', '《寻龙诀》票房破7亿', '近日，由乌尔善指导的国产3D电影《寻龙诀》正式登陆全国院线。上映4天，该片累计票房已突破7亿，影迷们普遍反映比其他国产3D片要好不止一个等级，也比前几个月上映的《九层妖塔》值不少，不管是剧情还是效果都属于国内一顶一的佳作，甚至可堪比部分好莱坞大片。有专家预测，《寻龙诀》总票房将有望超越《捉妖记》。 还记得2012年，《画皮2》作为国内第一部3D电影正式登陆，那时国内3D技术还处于萌芽阶段，而观众们对3D的认知也仅仅停留在好莱坞大片中，因此对于早期的转3D技术并不认可。而现在，随着技术的不断升级，国内也诞生了众多拥有一线技术的制作精英，其中灵动力量作为好莱坞级的制作团队，为国内3D电影工业做出了卓越的贡献。', '2015-12-02');
INSERT INTO `easybuy_news` VALUES ('10', '清华大学实验室爆炸一博士后遇难 ', '　昨日上午10时许，清华大学化学系何添楼二楼一实验室爆炸起火。据清华大学官微通报，事故现场发现一博士后实验人员死亡。新京报记者了解到，不幸死亡的博士后名为孟祥见，今年32岁，安徽萧县人，去年6月刚入校。昨晚6时，其家人已赶到学校处理后续事宜。                          　讲述:爆炸声沉闷，现场有多名学生　“爆炸当时震得地面一颤。”距离事发地点100米外是清华附中，一位学生家长看到清华化学实验楼腾起明火蹿出窗外，并冒出滚滚浓烟，随后赶紧拨打了119。　                                   有媒体披露，事故起因疑与高度易燃的化学药品叔丁基锂有关。公开资料显示，叔丁基锂是一种有机锂化合物，是有机合成中的超强碱，高度易燃，可在空气中自燃，储存时必须以干燥氮气保护，使用时也必须非常小心。', '2015-12-21');
INSERT INTO `easybuy_news` VALUES ('11', '《悟空传》终要搬上大银幕', '<p>日前，有微博博主晒出电影《悟空传》开机现场照。照片中，主演倪妮、余文乐、彭于晏和欧豪现身参加开机仪式，一起烧香祈福，祝愿开机大吉。另悉，剧中另一主演郑爽因拍摄《微微一笑很倾城》暂时缺席。</p>\r\n\r\n<p>电影《悟空传》改编自今何在（原名曾雨）于2000年开始创作的同名网络小说，由香港导演郭子健执导，今何在与郭子健联合编剧，彭于晏饰演孙悟空、余文乐出演二郎神、倪妮饰演紫霞、郑爽饰演阿月、欧豪饰演天蓬元帅。</p>\r\n\r\n<p>今何在的《悟空传》，在15年前开始于网络上连载时就广受欢迎，之后整理成书多次出版。</p>\r\n', '2015-12-22');
INSERT INTO `easybuy_news` VALUES ('12', '《叶问3》首映 1', '<p>新浪娱乐讯 12月16日，由黄百鸣<a href=\"http://weibo.com/1714193955?zw=ent\" target=\"_blank\">[微博]</a>监制、叶伟信<a href=\"http://weibo.com/1726826455?zw=ent\" target=\"_blank\">[微博]</a>执导、袁和平动作指导、演员甄子丹<a href=\"http://weibo.com/1194026233?zw=ent\" target=\"_blank\">[微博]</a>、熊黛林<a href=\"http://weibo.com/1722803755?zw=ent\" target=\"_blank\">[微博]</a>、张晋<a href=\"http://weibo.com/1266333761?zw=ent\" target=\"_blank\">[微博]</a>、谭耀文<a href=\"http://weibo.com/1293811174?zw=ent\" target=\"_blank\">[微博]</a>主演，世界级拳王泰臣强势加盟的《叶问3》于香港举办首映礼，并将于12月24日正式上映。</p>\r\n\r\n<p>　　首映礼上，监制黄百鸣先生表示：&ldquo;《叶问》电影系列每一集也有不同主题，第一集是《生存》、第二集是《生活》、来到第三集是《生命》，叶问师傅每一集都做很多好事去帮助别人，所以他在众人心目中是一个真正的英雄！希望大家看完《叶问3》后，会继续帮助别人。&rdquo;</p>\r\n\r\n<p>　　此次首映甄子丹带着妻子与一双儿女共同走红毯，幸福的一家四口让人不禁联想到他在片中的&ldquo;叶问&rdquo;形象。在说到自己心目中的&ldquo;真英雄&rdquo;时，甄子丹也表示：女性也可以是英雄，无论是以前还是现在，不少女性工作与家庭一并兼顾，相夫教子，看似简单，但她们有时也是有苦自己承担，所以他认为所有母亲都是英雄，绝对值得大家尊敬！</p>\r\n\r\n<p>　　而说到电影，他自己最期待的也是导演叶伟信最喜欢的一场戏：甄子丹饰演的叶问与张晋饰演的张志天&ldquo;咏春对咏春&rdquo;，主要因为他的师傅袁和平真的拍出咏春的味道，将咏春的拳、刀、棍一一展现给观众，而且他和张晋两人耍一招咏春，但有不同的风格，在拍摄上和演绎上都很有难度！这场戏是最值得大家欣赏的其中一场。</p>\r\n\r\n<p>　　在电影中甄子丹不仅与张晋有对手戏，《叶问3》还请来了拳王泰森。在之前的拍摄中就发生过甄子丹误伤泰森的事情，可见电影拍摄时也是历尽了不少曲折。这次《叶问3》相隔6年才再面世，只因为要精益求精，所以花了很多时间在构思故事。导演叶伟信也表示，此次除了主演甄子丹，还能够与泰森和袁和平合作，六年的等待也是值得的。....</p>\r\n', '2015-12-22');
INSERT INTO `easybuy_news` VALUES ('15', '三星Pay入华与支付宝、微信抢蛋糕', '商场买单时只需要将手机靠近P O S终端，进行指纹触摸完成购物体验；再或者只需连按智能手表的两侧按钮，表盘靠近读卡器即可。这样的场景很快就要到来。上周五，银联发布消息，同时与苹果及三星就ApplePay及三星Pay入华达成协议，并称2016年初推出此服务。', '2015-12-23');

-- ----------------------------
-- Table structure for `easybuy_order`
-- ----------------------------
DROP TABLE IF EXISTS `easybuy_order`;
CREATE TABLE `easybuy_order` (
  `eo_id` int(11) NOT NULL AUTO_INCREMENT,
  `eo_user_id` int(10) NOT NULL,
  `eo_create_time` date NOT NULL,
  `eo_cost` float DEFAULT NULL,
  `eo_status` int(11) NOT NULL,
  PRIMARY KEY (`eo_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of easybuy_order
-- ----------------------------
INSERT INTO `easybuy_order` VALUES ('1', '1', '2015-11-10', '300', '0');
INSERT INTO `easybuy_order` VALUES ('2', '2', '2014-03-06', '190', '1');

-- ----------------------------
-- Table structure for `easybuy_order_detail`
-- ----------------------------
DROP TABLE IF EXISTS `easybuy_order_detail`;
CREATE TABLE `easybuy_order_detail` (
  `eod_id` int(11) NOT NULL AUTO_INCREMENT,
  `eo_id` int(11) NOT NULL,
  `ep_id` int(11) NOT NULL,
  `eod_quantity` int(11) NOT NULL,
  `eod_cost` float DEFAULT NULL,
  PRIMARY KEY (`eod_id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of easybuy_order_detail
-- ----------------------------
INSERT INTO `easybuy_order_detail` VALUES ('1', '1', '1', '2', '300');
INSERT INTO `easybuy_order_detail` VALUES ('2', '1', '2', '1', '100');
INSERT INTO `easybuy_order_detail` VALUES ('3', '2', '6', '1', '10');
INSERT INTO `easybuy_order_detail` VALUES ('4', '2', '3', '2', '100');
INSERT INTO `easybuy_order_detail` VALUES ('5', '2', '4', '1', '20');
INSERT INTO `easybuy_order_detail` VALUES ('6', '14', '16', '2', null);
INSERT INTO `easybuy_order_detail` VALUES ('7', '14', '2', '2', null);
INSERT INTO `easybuy_order_detail` VALUES ('8', '14', '4', '2', null);
INSERT INTO `easybuy_order_detail` VALUES ('9', '15', '16', '2', null);
INSERT INTO `easybuy_order_detail` VALUES ('10', '15', '2', '2', null);
INSERT INTO `easybuy_order_detail` VALUES ('11', '15', '4', '2', null);
INSERT INTO `easybuy_order_detail` VALUES ('12', '16', '4', '2', null);
INSERT INTO `easybuy_order_detail` VALUES ('13', '17', '2', '2', null);
INSERT INTO `easybuy_order_detail` VALUES ('14', '17', '4', '2', null);
INSERT INTO `easybuy_order_detail` VALUES ('15', '17', '6', '1', null);
INSERT INTO `easybuy_order_detail` VALUES ('16', '18', '2', '1', null);
INSERT INTO `easybuy_order_detail` VALUES ('22', '23', '3', '4', null);
INSERT INTO `easybuy_order_detail` VALUES ('25', '25', '5', '1', null);
INSERT INTO `easybuy_order_detail` VALUES ('26', '25', '12', '1', null);
INSERT INTO `easybuy_order_detail` VALUES ('27', '26', '1', '1', null);
INSERT INTO `easybuy_order_detail` VALUES ('28', '27', '9', '1', null);
INSERT INTO `easybuy_order_detail` VALUES ('29', '28', '7', '2', null);
INSERT INTO `easybuy_order_detail` VALUES ('30', '29', '3', '1', null);
INSERT INTO `easybuy_order_detail` VALUES ('31', '29', '6', '2', null);
INSERT INTO `easybuy_order_detail` VALUES ('32', '30', '3', '1', null);
INSERT INTO `easybuy_order_detail` VALUES ('33', '31', '16', '1', null);
INSERT INTO `easybuy_order_detail` VALUES ('34', '32', '3', '3', null);
INSERT INTO `easybuy_order_detail` VALUES ('35', '33', '7', '2', null);
INSERT INTO `easybuy_order_detail` VALUES ('36', '33', '30', '2', null);

-- ----------------------------
-- Table structure for `easybuy_product`
-- ----------------------------
DROP TABLE IF EXISTS `easybuy_product`;
CREATE TABLE `easybuy_product` (
  `ep_id` int(11) NOT NULL AUTO_INCREMENT,
  `ep_name` varchar(30) NOT NULL DEFAULT '',
  `ep_description` varchar(1000) DEFAULT NULL,
  `ep_price` float NOT NULL,
  `ep_stock` int(11) DEFAULT NULL,
  `epc_id` int(11) NOT NULL,
  `ep_file_name` varchar(200) NOT NULL,
  PRIMARY KEY (`ep_id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of easybuy_product
-- ----------------------------
INSERT INTO `easybuy_product` VALUES ('1', 'testtest', 'qqqqqtesttest', '32', '9000', '0', 'images/8.jpg');
INSERT INTO `easybuy_product` VALUES ('2', 'aaaaaa', 'wwwwwwtesttets', '28', '8999', '0', 'images/Chrysanthemum.jpg');
INSERT INTO `easybuy_product` VALUES ('3', '巴黎圣母院 高老头', '商城正版 佳作必读丛书 青少版 茶花女 巴黎圣母院 高老头 海底两万里 悲惨世界 钢铁是怎样炼成的 假如给我三天光明 海的女儿   产品名称：复活 巴黎圣母院 钢铁是怎...是否是套装: 是书名: 复活 巴黎圣母院 钢铁是怎样炼成的 红与黑 高老头定价: 122.00元出版社名称: 中央编译出版社作者: 无书名: 复活 巴黎圣母院 钢铁是怎样炼成', '8', '10000', '0', 'images/Penguins.jpg');
INSERT INTO `easybuy_product` VALUES ('4', '孙子兵法与三十六计', '孙子兵法与三十六计正版包邮 孙子兵书线装原著文白对照精装全集中国历史军事珍藏图书籍礼品装含注释译文延伸 产品名称：孙子兵法与三十六计是否是套装: 是书名: 孙子兵法与三十六计定价: 1580.00元出版社名称: 光明日报出版社出版时间: 2012年6月作者: 孙武等开本: 16开书名: 孙子兵法与三十六计', '98', '2300', '0', 'images/Koala.jpg');
INSERT INTO `easybuy_product` VALUES ('5', '中华成语大词典', '中华成语大词典单色本最新版现代成语词典初高中学生新华汉语成语大全字典辞书 辞典现代成语大字典工具书  产品名称：成语大词典(单色本最新修...是否是套装: 否书名: 成语大词典(单色本最新修订版)(精)定价: 68.00元出版社名称: 商务国际出版时间: 2013年01月作者: 成语大词典编委会作者地区: 中国大陆编者: 成语大词典开本: 32书名: 成语大词典(单色本最新修订版)(精)', '35', '50000', '3', 'images/5.jpg');
INSERT INTO `easybuy_product` VALUES ('6', '新汉英词典商务英语字典', '现货新汉英词典商务英语字典大最新版本英语词典汉译英 英语文翻译初高中学生精装英语字典正版包邮   产品名称：新英汉汉英词典是否是套装: 否书名: 新英汉汉英词典定价: 68.00元出版社名称: 商务印书馆国际有限公司出版时间: 2015年1月作者: 无书名: 新英汉汉英词典', '18', '30000', '3', 'images/6.jpg');
INSERT INTO `easybuy_product` VALUES ('7', '自我按摩保健全书', '正版包邮 自我按摩保健全书超值全彩白金版 从零开始学健康按摩保健图书自我按摩的原理与概念 中医养生保健健康 家庭实用保健手册   产品名称：自我按摩保健全书是否是套装: 否书名: 自我按摩保健全书定价: 68.00元出版社名称: 中医古籍出版社作者: 曹力开本: 16开书名: 自我按摩保健全书', '21.5', '100000', '4', 'images/7.jpg');
INSERT INTO `easybuy_product` VALUES ('8', '马博士谈营养', '预售12.27发】正版包邮 健康中国 马博士谈营养 每天学点营养知识保健养生跟着靠谱营养学专家重上营养公开课 马冠生著 饮食健康   产品名称：营养指导是否是套装: 否书名: 营养指导定价: 23.50元出版社名称: 中国人民大学出版社出版时间: 2010年09月作者: 邹凌燕，杨子艳 主编编者: 邹凌燕;杨子艳开本: 16书名: 营养指导', '19.5', '9000', '0', 'images/8.jpg');
INSERT INTO `easybuy_product` VALUES ('9', '韩国新生活化妆品正品', '韩国新生活化妆品正品 荟馨萌动新生洗面奶 丰富泡沫 包邮    上市时间: 1995年功效: 补水规格类型: 正常规格品牌: MIZCHO/美之娇品名: 美之娇中干三件套适合肤质: 中性及干性肤质产地: 中国保质期: 4年', '24', '100000', '5', 'images/01.jpg');
INSERT INTO `easybuy_product` VALUES ('10', '百雀羚化妆品套装', '百雀羚化妆品套装女水嫩倍现护肤品五件套爽肤水乳液冬季补水保湿    颜色分类: 精华水+精华乳+精华霜 套装1（洁面+水+乳液+面霜） 套装2（水+乳+霜+眼霜） 套装3（洁面+水+乳+霜+眼部） 套装4（洁面+水+乳液+面霜+面膜） 套装5（洁面+水+乳+面霜+精华）功效: 美白 补水 保湿 控油 抗皱 提拉紧致 提亮肤色规格类型: 正常规格品牌: PECHOIN/百雀羚面部护理套装: 水嫩倍现保湿礼盒装适合肤质: 任何肤质产地: 中国', '280', '80000', '5', 'images/02.jpg');
INSERT INTO `easybuy_product` VALUES ('11', '家居生活情侣拖鞋', '限量9.9包邮无印良品家居生活情侣拖鞋轻巧无声不伤地板家居拖鞋    中底材质: 人造长毛绒帮面材质: 绒面款式: 高包跟适用场地: 居家拖鞋鞋底厚度: 1.5cm(含)-3.5cm(不含)鞋底材质: 橡胶风格: 卡通风适用季节: 冬季适用对象: 情侣鞋码: 36/37【适合平时34/35】 38/39【适合平时36/37】 40/41【适合平时38/39】 42/43【适合平时40/41】 44/45【适合平时42/43】颜色分类: 深蓝色 棕色 狗狗款咖啡色 狗狗款米黄色 狗狗款浅红 狗狗款铁锈红 狗狗款浅湖绿 粉红色 桃红色 藏蓝 羊羊款卡其色 羊羊款灰色 羊羊款雪芽色 羊羊款天蓝色 羊羊款粉色货号: 9811品牌: 南陌', '9', '10000', '6', 'images/03.jpg');
INSERT INTO `easybuy_product` VALUES ('12', '我爱生活雪尼尔挂式擦手巾', '我爱生活雪尼尔挂式擦手巾厨房可爱擦手毛巾酒店卫生间搽手巾手帕   品牌: 我爱生活货号: 11颜色分类: 雪尼尔 灰色 小动物绿蛙 小动物蓝狗 擦手球粉色 擦手球米黄 小动物藏青兔 超纤动物绿 超纤动物黄 超纤动物粉 超纤 灰色 超纤 粉色 雪尼尔 米黄 小动物橙鸭 小动物紫熊 超纤动物蓝 小动物红猪 超纤 米白适用性别: 通用', '6.5', '5000', '6', 'images/04.jpg');
INSERT INTO `easybuy_product` VALUES ('13', '车载加热饭盒插电', '壹生活 车载加热饭盒插电 迷你保温电热饭盒 便携不锈钢热饭器   证书编号：2012010717556731证书状态：有效申请人名称：中山市十度良品电器有限公司制造商名称：中山市十度良品电器有限公司产品名称：液体加热器3C产品型号：SD-913 100W, SD-915 100W, SD-916 100W, SD-917 150W...产品名称：Seed/十度良品 SD-922 S...品牌: Seed/十度良品 型号: SD-922货号: SD-922颜色分类: 卡其色 粉色层数: 2层内胆材质: 不锈钢功能: 真空保鲜 其他/other 蒸煮 加热', '138', '1999', '6', 'images/05.jpg');
INSERT INTO `easybuy_product` VALUES ('14', 'ON THE BODY 香水沐浴露', '韩国LG直营正品 ON THE BODY 香水沐浴露 快乐微风 500ML*2    品牌: LUX/力士型号: 幽莲加迷情套装是否量贩装: 否功能: 其他净含量: 其他', '88', '2800', '7', 'images/06.jpg');
INSERT INTO `easybuy_product` VALUES ('15', '安利雅蜜润肤沐浴露', '【优质生活】安利雅蜜润肤沐浴露750ml    产品名称：AMWAY/安利 雅蜜润肤沐浴...品牌: AMWAY/安利型号: 雅蜜润肤沐浴露是否量贩装: 否功能: 美白 滋润保湿 清洁 清凉舒爽净含量: 250mL 750mL适用对象: 通用规格类型: 常规单品保质期: 24个月产地: 中国大陆', '80', '9999', '7', 'images/07.jpg');
INSERT INTO `easybuy_product` VALUES ('16', 'LG生活健康竹盐精品清雅竹香香皂', 'LG生活健康竹盐精品清雅竹香香皂110G   产品名称：BAMBOO SALT/竹盐 精品香...品牌: BAMBOO SALT/竹盐型号: 精品香皂是否量贩装: 否功能: 保湿 清洁净含量: 110g适用对象: 通用规格类型: 常规单品产地: 中国大陆', '9.5', '10000', '7', 'images/08.jpg');
INSERT INTO `easybuy_product` VALUES ('17', '真艾便携纸香皂', '正安生活 艾草艾叶蕲艾户外洗手杀菌除味消毒香皂 真艾便携纸香皂    品牌: Wellhouse产地: 中国货号: 002上市时间: 2014年夏季包装种类: 盒装', '9', '8000', '7', 'images/09.jpg');
INSERT INTO `easybuy_product` VALUES ('18', 'SONGX 松心电器 电饭锅', 'SONGX 松心电器FSA18微电脑式日本技术电饭煲5L 智能预约电饭锅   产品名称：Midea/美的 MB-WFZ4010X...品牌: Midea/美的型号: MB-WFZ4010XM能效等级: 无颜色分类: 香槟金容量: 4L控制方式: 微电脑式电饭煲多功能: 煲仔饭 预约 煮饭内胆材质: 钛金厚釜功率: 1201W以上售后服务: 全国联保形状: 方形加热方式: 三维立体加热适用人数: 2人-6人', '699', '6000', '8', 'images/11.jpg');
INSERT INTO `easybuy_product` VALUES ('19', '帝依烧水壶', '帝依烧水壶陶瓷电热水壶养生壶电茶壶抽水电器自动上水断电防干烧   壶体层数: 单层智能类型: 其他温控器类型: 进口温控器电水壶加热速度: 6分钟(含)-10分钟(含)电热水壶容积: 1.8L电热水壶材质: 玻璃电热水壶类型: 电热水壶保温功能: 有附加功能: 自动断电电热水壶售后服务: 店铺三包颜色分类: 玉白色电热水壶品牌: 净益康刻度标示: 壶体标示加热方式: 底盘加热', '318', '2800', '8', 'images/12.jpg');
INSERT INTO `easybuy_product` VALUES ('20', '全自动电饼铛烙饼机', '多功能小蛋糕机家用全自动电饼铛烙饼机迷你卡通正品特价厨房电器   证书编号：2013010712609736证书状态：有效申请人名称：北京利仁科技有限责任公司制造商名称：北京利仁科技有限责任公司产品名称：带圈的电饼铛3C产品型号：LR-300i, LR-328A, LR-328B 220V～ 50Hz 1200W产品名称：利仁 LR-328A品牌: 利仁型号: LR-328A货号: LR-328A颜色分类: 红色+黑色功能: 烤 炸 炒 烙 煎电饼铛加热面: 双面加热烙盘设计: 悬浮式功率: 1001W(含)-1200W(含)口径: 29cm(含)-31cm(含)饼铛类型: 电饼铛售后服务: 全国联保', '88', '9999', '8', 'images/13.jpg');
INSERT INTO `easybuy_product` VALUES ('22', '华为', '【产品名称】：荣耀畅玩5X KIW-TL00 移动版(2GRAM+16GROM) 破晓银 双卡双待', '1111', '1400', '9', 'images/14.jpg');
INSERT INTO `easybuy_product` VALUES ('23', '华为Mate 8（NXT-AL10/3GB RAM/全网通）', '4G网络：移动TD-LTE，	网络类型：双卡（均可支持4G），主屏尺寸：6英寸 1920x1080像素	CPU型号：海思 Kirin 950+微智CPU频率：2.3GHz（大四核），1.8GHz（小四核）	', '2550', '999', '9', 'images/14.jpg');
INSERT INTO `easybuy_product` VALUES ('25', '原封现货-Meizu/魅族', '原封现货-Meizu/魅族 魅蓝 metal 公开版版移动联通双4G指纹识别 买就送：2.5D钢化玻璃膜+透白软胶壳+剪卡器', '1099', '888', '9', 'images/16.jpg');
INSERT INTO `easybuy_product` VALUES ('26', '苹果iPhone 6S（全网通）', '主屏尺寸：4.7英寸 主屏分辨率：1334x750像素 后置摄像头：1200万像素 前置摄像头：500万像素 电池容量：1715mAh 电池类型：不可拆卸式电池 核心数：双核 内存2G', '999', '10', '9', 'images/15.jpg');
INSERT INTO `easybuy_product` VALUES ('27', '10.5寸超大视网膜屏分辨率', '超强八核处理器，存储运行DDR4G，机身16G/32G超大存储。10.5寸超大视网膜屏分辨率   品牌: 佩派屏幕尺寸: 10英寸以上网络类型: 4G热门功能: WiFi/重力感应/HDMI/3G外挂/U盘外挂 电话 重力感应 原笔迹手写 可拆卸键盘 罗盘功能 陀螺仪 光线感应 HDMI 人脸识别 蓝牙 无 GPS 3G通话 FM 智能重力感应 方向感应器 原手迹手写 TPM基本系统硬盘容量: 64GB操作系统: 安卓Android版本: Android4.4分辨率: 2048x1536触摸屏类型: 电容屏CPU主频: 2.0GHz内存容量: 8GB是否支持蓝牙: 支持摄像头类型: 双摄像头存储类型: 固态硬盘接口类型: 音频接口 USB 网口 HDMI SIM卡 VGA 音频输入 音频输出 闪存卡读取 其他/other TV OTG 电脑锁 3G上网卡预留接口上市时间: 2014月份: 12月颜色分类: 蓝宝石视网膜16G白 蓝宝石视网膜32G白 蓝宝石视网膜40G白 蓝宝石视网膜48G白 蓝宝石视网膜64G白 蓝宝石视网膜80G白 蓝宝石视网膜16G黑 蓝宝石视网膜32G黑 蓝宝石视网膜40G黑 蓝宝石视网膜48G黑 蓝宝石视网膜64G黑 蓝宝石视网膜80G黑 极清蓝宝石视网膜通话16G 极清蓝宝石视网膜通话32G 极清蓝宝石视网膜通话40G 极清蓝宝石视网膜通话48G 极清蓝宝石视网膜通话64G 极清蓝宝石视网膜通话80G 极清4K土豪八核通话40G 极清4K土豪八核通话48G 极清4K土豪八核通话64G 极清4K土豪八核通话80G售后服务: 全国联保套餐类型: 官方标配 套餐一 套餐二 套餐三 套餐四 套餐五成色: 全新', '668', '90', '11', 'images/18.jpg');
INSERT INTO `easybuy_product` VALUES ('28', '戴尔五代i7/i5笔记本', '本本是统一银色全金属外观的！双硬盘大容量配置版本    产品名称: Dell/戴尔 xps13 XPS13D-8808包装体积: 316mm×205mm×18mm屏幕类型: 宽屏是否PC平板二合一: 否毛重: 1.57kg品牌: Dell/戴尔系列: xps13XPS13: XPS13D-8808屏幕尺寸: 13.3英寸屏幕比例: 16:9CPU平台: Intel Core i7-4510U显卡类型: Intel HD Graphics 4400显存容量: 共享内存容量机械硬盘容量: 无机械硬盘固态硬盘: 256g内存容量: 8GB光驱类型: 无光驱适用场景: 家庭影音 轻薄便携 高清游戏 尊贵旗舰重量: 1kg(含)-1.5kg(不含)锂电池电芯数量: 6芯锂电池售后服务: 店铺三包颜色分类: 灰色 白色 褐色 银色上市时间: 2014年月份: 6月操作系统: windows 8.1通信技术类型: 无线网卡 蓝牙输入设备: 触摸板附加功能: HDMI接口 摄像头功能 扬声器 USB 3.0套餐类型: 标准套餐 套餐一 套餐二 套餐三 套餐四 官方标配成色: 全新是否超极本: 否是否内置电池: 内置电池分辨率: 1920x1080是否触摸屏: 非触摸屏', '3558', '9999', '11', 'images/19.jpg');
INSERT INTO `easybuy_product` VALUES ('30', '苹果笔记本电脑', '产品名称：Apple/苹果 MacBook Pro ...能效等级: 无品牌: Apple/苹果MacBook Pro系列型号: MF840CH/A屏幕尺寸: 13.3英寸CPU平台: Intel Core i5-5257U(2.7GHz)显卡类型: Intel Iris Graphics 6100显存容量: 共享内存容量机械硬盘容量: 无机械硬盘内存容量: 8GB操作系统: Mac OS', '7285', '99', '11', 'images/computer3.jpg');

-- ----------------------------
-- Table structure for `easybuy_product_category`
-- ----------------------------
DROP TABLE IF EXISTS `easybuy_product_category`;
CREATE TABLE `easybuy_product_category` (
  `epc_id` int(11) NOT NULL AUTO_INCREMENT,
  `epc_name` varchar(20) NOT NULL,
  `epc_parent_id` int(11) NOT NULL,
  PRIMARY KEY (`epc_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of easybuy_product_category
-- ----------------------------
INSERT INTO `easybuy_product_category` VALUES ('1', '儿童文学', '1');
INSERT INTO `easybuy_product_category` VALUES ('2', '青少年读物', '1');
INSERT INTO `easybuy_product_category` VALUES ('3', '教辅工具书', '1');
INSERT INTO `easybuy_product_category` VALUES ('4', '生活百科', '1');
INSERT INTO `easybuy_product_category` VALUES ('5', '护肤品', '2');
INSERT INTO `easybuy_product_category` VALUES ('6', '居家用品', '2');
INSERT INTO `easybuy_product_category` VALUES ('7', '洗浴用品', '2');
INSERT INTO `easybuy_product_category` VALUES ('8', '家用电器', '3');
INSERT INTO `easybuy_product_category` VALUES ('9', '手机', '3');
INSERT INTO `easybuy_product_category` VALUES ('11', '电脑', '3');

-- ----------------------------
-- Table structure for `easybuy_product_parent`
-- ----------------------------
DROP TABLE IF EXISTS `easybuy_product_parent`;
CREATE TABLE `easybuy_product_parent` (
  `epc_parent_id` int(11) NOT NULL AUTO_INCREMENT,
  `epc_parent_name` varchar(20) NOT NULL,
  PRIMARY KEY (`epc_parent_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of easybuy_product_parent
-- ----------------------------
INSERT INTO `easybuy_product_parent` VALUES ('1', '图书');
INSERT INTO `easybuy_product_parent` VALUES ('2', '生活用品');
INSERT INTO `easybuy_product_parent` VALUES ('3', '电器');

-- ----------------------------
-- Table structure for `easybuy_user`
-- ----------------------------
DROP TABLE IF EXISTS `easybuy_user`;
CREATE TABLE `easybuy_user` (
  `eu_user_id` int(10) NOT NULL AUTO_INCREMENT,
  `eu_user_name` varchar(20) NOT NULL,
  `eu_name` varchar(20) DEFAULT '',
  `eu_password` varchar(20) NOT NULL,
  `eu_sex` varchar(6) NOT NULL DEFAULT '',
  `eu_birthday` date DEFAULT NULL,
  `eu_identity_code` varchar(18) DEFAULT NULL,
  `eu_email` varchar(80) DEFAULT NULL,
  `eu_mobile` varchar(11) NOT NULL,
  `eu_address` varchar(200) NOT NULL,
  `eu_login` int(11) DEFAULT NULL,
  `eu_status` int(11) DEFAULT NULL,
  PRIMARY KEY (`eu_user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of easybuy_user
-- ----------------------------
INSERT INTO `easybuy_user` VALUES ('1', 'sherry', '孙婷', '123456', '女', '1996-06-29', '362426234522246675', 'sherry@163.com', '18573359008', '江西吉安', '0', '0');
INSERT INTO `easybuy_user` VALUES ('2', 'mark', '李四', '123456', '男', '1995-02-28', '231456172835671098', 'mark@163.com', '18448064361', '广东深圳', '0', '0');
INSERT INTO `easybuy_user` VALUES ('3', 'xiao', '小明1', '888888', 'male', '2015-12-01', '32123467890653247', 'xiao@163.com', '17289058009', '江西', null, null);
INSERT INTO `easybuy_user` VALUES ('4', 'test', '张三', '666666', 'male', '2014-12-11', '2134337548888888', 'test@163.com', '14223531332', '广东', null, null);
INSERT INTO `easybuy_user` VALUES ('5', 'li', '安妮', '123456', 'female', '2015-12-13', '3164576987986434', 'li@163.com', '14223531332', '广东', null, null);
INSERT INTO `easybuy_user` VALUES ('6', 'john', '约翰', '111', 'male', '2015-12-01', '3164576987986434', 'john@163.com', '17289058009', '江西', null, null);
INSERT INTO `easybuy_user` VALUES ('7', 'jane', '简', '666666', 'female', '1995-02-28', '321355643726537', 'jane@163.com', '14353113435', '湖北', null, null);
INSERT INTO `easybuy_user` VALUES ('8', 'zhang', '张', '666666', 'male', '1996-01-20', '6388798097675554', 'zhang@163.com', '15623452178', '河北', null, null);
INSERT INTO `easybuy_user` VALUES ('9', 'lisi', '李', '111', 'male', '2013-12-13', '6353226363462632', 'lisi@163.com', '13265768843', '江西', null, null);
INSERT INTO `easybuy_user` VALUES ('11', 'kobe', '刘tssss', '1234', 'male', '1998-09-08', '', '', '18679176543', '泰豪动漫学院1', null, null);
