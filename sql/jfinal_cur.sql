/*
 Navicat Premium Data Transfer

 Source Server         : connection
 Source Server Type    : MySQL
 Source Server Version : 80031 (8.0.31)
 Source Host           : localhost:3306
 Source Schema         : jfinal_cur

 Target Server Type    : MySQL
 Target Server Version : 80031 (8.0.31)
 File Encoding         : 65001

 Date: 25/04/2023 17:45:48
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_blog
-- ----------------------------
DROP TABLE IF EXISTS `t_blog`;
CREATE TABLE `t_blog`  (
  `blog_id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `user_id` int NOT NULL,
  PRIMARY KEY (`blog_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 94 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_blog
-- ----------------------------
INSERT INTO `t_blog` VALUES (1, 'Hello JFinal !?', 'Hello! Hello! Hello! Hello! Hello! Hello! Hello! Hello! Hello! Hello! Hello!', 1);
INSERT INTO `t_blog` VALUES (2, 'Goodbye JFinal !', 'Goodbye! Goodbye! Goodbye! Goodbye! Goodbye! \r\nGoodbye! Goodbye! Goodbye! Goodbye! Goodbye! ', 1);
INSERT INTO `t_blog` VALUES (3, '​川普已经事实上被共和党抛弃了吧？', '川普已经被正式逮捕，到现在好像还没看到哪位共和党大佬发过声？', 3);
INSERT INTO `t_blog` VALUES (4, '葡萄牙里斯本平均房租1350欧，数千人抗议', '如题', 3);
INSERT INTO `t_blog` VALUES (5, '今天很冷啊', '这意味着什么?', 3);
INSERT INTO `t_blog` VALUES (6, '里斯本在欧洲算几线城市？', '话说鸟市的这边 康尔佳超市公交车站那个地方两室一厅的房租是2000左右，这个地方下一站是县医院，下下一站是铁路局，可以说是中心地带了。', 3);
INSERT INTO `t_blog` VALUES (7, '这个视频对多货币结算体系讲得非常好啊，推荐给大家', '之前印度和毛子想用卢布卢比来买油气，最终因为印度对毛子是巨额逆差而作罢', 3);
INSERT INTO `t_blog` VALUES (8, '海峡中北部联合巡航巡查专项行动今日启动', '字数越少事越大', 4);
INSERT INTO `t_blog` VALUES (9, '​要求澄清有无芯片限制协议', '当地时间4月3日至4日，世界贸易组织货物贸易理事会举行会议。', 4);
INSERT INTO `t_blog` VALUES (10, 'What does the fox say ?', 'Suck it, loser.', 2);
INSERT INTO `t_blog` VALUES (11, '我将发表一个话题,然后注销', 'IT屋\r\na.测试一下我写的一个java代码片段是否有BUG\r\nb.使用的产品栏目是编译工具里面的java在线测试\r\nc.使用软件的过程中,我没遇到什么答问题,且亮点是功能齐全,各大编程语言都有涵盖\r\nd.从用户角度的体验来说,广告比较多,影响观感', 14);
INSERT INTO `t_blog` VALUES (12, '用魔法恶心魔法', '由于 Online Compiler and IDE 和 IT屋 是由不同的开发人员和团队维护的，因此它们可能存在一些已知或未知的错误（BUG）', 15);
INSERT INTO `t_blog` VALUES (13, '​马克龙来了也没什么用啊，何况还带了一个看守', '自己在国内都是风雨飘扬，万一真搞出点什么对欧洲有利的事来，怕不是要真被送上断头台。\r\n带冯来也是给美国看的', 15);
INSERT INTO `t_blog` VALUES (14, '我发一下我这个账号的密码,大家楼下也帮忙发一下自己的', '密码1234,OK大伙行动!', 6);
INSERT INTO `t_blog` VALUES (15, '我想成为发帖最多的人,不过分吧', '有人比我多吗 ? 有人比我多吗 ? 有人比我多吗 ? 有人比我多吗 ? 有人比我多吗 ? 有人比我多吗 ? 有人比我多吗 ?', 4);
INSERT INTO `t_blog` VALUES (16, '前两天法国搞了笔人民币结算，马客服还是能搞点事的啊', '随便了，猪肝肠看着着不也声势浩大，反正吃瘪又不是赛里斯吃瘪。', 2);
INSERT INTO `t_blog` VALUES (17, '好困啊', '如题,还有人也困的吗', 9);
INSERT INTO `t_blog` VALUES (18, '第一次发帖, 好紧张啊', 'it1352这个网站有什么BUG吗', 8);
INSERT INTO `t_blog` VALUES (19, '第二次发帖,好紧张啊', '我已经流浪了如此之久', 8);
INSERT INTO `t_blog` VALUES (20, '第三次发帖', '第三次发帖第三次发帖第三次发帖第三次发帖第三次发帖第三次发帖第三次发帖第三次发帖第三次发帖第三次发帖第三次发帖第三次发帖第三次发帖第三次发帖', 8);
INSERT INTO `t_blog` VALUES (21, '第四次发帖', '第四次发帖第四次发帖第四次发帖第四次发帖,我也太能水了吧', 8);
INSERT INTO `t_blog` VALUES (22, '第五次发帖', '这论坛怎么一个人都没有', 8);
INSERT INTO `t_blog` VALUES (23, '第六次发帖', '第六次发帖第六次发帖', 8);
INSERT INTO `t_blog` VALUES (24, '第七次发帖', '第七次发帖第七次发帖第七次发帖第七次发帖第七次发帖第七次发帖第七次发帖第七次发帖第七次发帖第七次发帖第七次发帖第七次发帖第七次发帖第七次发帖第七次发帖第七次发帖第七次发帖第七次发帖', 8);
INSERT INTO `t_blog` VALUES (25, '第八次发帖', '第八次发帖第八次发帖第八次发帖第八次发帖第八次发帖第八次发帖第八次发帖第八次发帖第八次发帖第八次发帖第八次发帖第八次发帖第八次发帖第八次发帖第八次发帖第八次发帖第八次发帖第八次发帖第八次发帖第八次发帖第八次发帖第八次发帖第八次发帖第八次发帖第八次发帖第八次发帖第八次发帖第八次发帖第八次发帖第八次发帖', 8);
INSERT INTO `t_blog` VALUES (26, '第九次发帖', '第九次发帖第九次发帖第九次发帖第九次发帖第九次发帖第九次发帖第九次发帖第九次发帖第九次发帖第九次发帖第九次发帖第九次发帖第九次发帖第九次发帖', 8);
INSERT INTO `t_blog` VALUES (27, '第十次发帖', '第十次发帖第十次发帖第十次发帖第十次发帖第十次发帖第十次发帖第十次发帖第十次发帖第十次发帖第十次发帖第十次发帖第十次发帖第十次发帖第十次发帖第十次发帖第十次发帖第十次发帖第十次发帖第十次发帖第十次发帖第十次发帖第十次发帖第十次发帖第十次发帖第十次发帖第十次发帖第十次发帖', 8);
INSERT INTO `t_blog` VALUES (28, 'Aaaa啊啊啊', 'aaaaaaaaaaaaaaaaaaaaaa', 8);
INSERT INTO `t_blog` VALUES (29, 'Bbbb啊啊啊', 'bbbbbbbbbbbbbbbbbbbbbb', 8);
INSERT INTO `t_blog` VALUES (30, 'Cccc啊啊啊', 'ccccccccccccccccccccc', 2);
INSERT INTO `t_blog` VALUES (31, 'Dddd啊啊啊', 'dddddddddddddddddddd', 3);
INSERT INTO `t_blog` VALUES (32, 'Eeee啊啊啊', 'eeeeeeeeeeeeeeeee', 3);
INSERT INTO `t_blog` VALUES (33, 'Ffff啊啊啊', 'fffffffffffff', 2);
INSERT INTO `t_blog` VALUES (34, 'Gggg啊啊啊', 'gggggggggggggggggg', 3);
INSERT INTO `t_blog` VALUES (35, 'Hhhh啊啊啊', 'hhhhhhhhhhhhhhhhhhhhhhhh', 2);
INSERT INTO `t_blog` VALUES (36, 'Iiiii啊啊啊', 'iiiiiiiiiiiiiiiiiii', 8);
INSERT INTO `t_blog` VALUES (37, 'Jjjj啊啊啊', 'jjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjj', 4);
INSERT INTO `t_blog` VALUES (38, 'Kkkk啊啊啊', 'kkkkkkkkkkkkkkkkkkkkkkk', 4);
INSERT INTO `t_blog` VALUES (39, 'Llll啊啊啊', 'lllllllllllllllllllllllllllllll', 2);
INSERT INTO `t_blog` VALUES (40, 'Mmmm啊啊啊', 'mmmmmmmmmmmmmmmmmmmmmmm', 3);
INSERT INTO `t_blog` VALUES (41, 'Nnnn啊啊啊', 'nnnnnnnnnnnnnnnnnnnnnnn', 6);
INSERT INTO `t_blog` VALUES (42, 'Oooo啊啊啊', 'oooooooooooooooooooooooo', 4);
INSERT INTO `t_blog` VALUES (43, 'Pppp啊啊啊', 'ppppppppppppppppppppppppppppppp', 15);
INSERT INTO `t_blog` VALUES (44, 'Qqqq啊啊啊', 'qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq', 7);
INSERT INTO `t_blog` VALUES (45, 'Rrrr啊啊啊', 'rrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr', 7);
INSERT INTO `t_blog` VALUES (46, 'Ssss啊啊啊', 'sssssssssssssssssssssssssssssssssssssssssssssss', 7);
INSERT INTO `t_blog` VALUES (47, 'Tttt啊啊啊', 'tttttttttttttttttttttttttttttttttttttttttttttttttttt', 8);
INSERT INTO `t_blog` VALUES (48, 'Uuuu啊啊啊', 'uuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuu', 8);
INSERT INTO `t_blog` VALUES (49, 'Vvvv啊啊啊', 'vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv', 8);
INSERT INTO `t_blog` VALUES (50, 'Wwww啊啊啊', 'wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww', 3);
INSERT INTO `t_blog` VALUES (51, 'Xxxx啊啊啊', 'xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx', 3);
INSERT INTO `t_blog` VALUES (52, 'Yyyy啊啊啊', 'yyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy', 3);
INSERT INTO `t_blog` VALUES (53, 'Zzzz啊啊啊', 'zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz', 4);
INSERT INTO `t_blog` VALUES (54, '狗儿不能离开主人出现在公共场所', '而且还必须带着项圈和狗绳。', 3);
INSERT INTO `t_blog` VALUES (55, '美国3月ADP就业人数增加14.5万，预估为增加21万', '如题', 10);
INSERT INTO `t_blog` VALUES (56, '加拿大LGBT团体群星闪耀', '如题', 11);
INSERT INTO `t_blog` VALUES (57, '特朗普的律师前额和假人的腿。', '如题', 4);
INSERT INTO `t_blog` VALUES (58, '克林顿宣称：后悔当年让乌放弃核武器，不然俄不会行动', '如题', 13);
INSERT INTO `t_blog` VALUES (59, '沙伊外长还要来啊', '如题', 14);
INSERT INTO `t_blog` VALUES (60, '不行了，知乎看到的一个地狱笑话要把我从椅子上笑下来了 ', '如题', 10);
INSERT INTO `t_blog` VALUES (61, '老布什吃日本过宴呕吐是因为看见鱼生', '想起了被日本做成人肉刺生的战友', 11);
INSERT INTO `t_blog` VALUES (62, '[速报] 贝卢斯科尼进ICU了啊', '哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈', 12);
INSERT INTO `t_blog` VALUES (63, '要求澄清有无芯片限制协议啊', '哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈', 4);
INSERT INTO `t_blog` VALUES (64, '	问一下，乌克兰和俄罗斯现在什么情况啊', '哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈', 14);
INSERT INTO `t_blog` VALUES (65, '去曼彻斯特旅游要交游客税啊', '哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈', 14);
INSERT INTO `t_blog` VALUES (66, '“我所犯下的唯一罪行，是无畏的保护我们的国家”', '如题', 1);
INSERT INTO `t_blog` VALUES (67, '[观察] 日本麦当劳汉堡套餐啊', '如题', 2);
INSERT INTO `t_blog` VALUES (68, '	现在欧美游戏全是这种lgbt设定加上奇丑无比的造型啊', '如题', 3);
INSERT INTO `t_blog` VALUES (69, '意呆利禁止chatgpt的原因啊', '如题', 4);
INSERT INTO `t_blog` VALUES (70, '	韩媒：净利润增长近五倍，中国比亚迪交出完美成绩单啊', '如题', 5);
INSERT INTO `t_blog` VALUES (71, '民主党要是起诉期间撤走特勤局啊，然后让伊朗动手呢？', '如题', 6);
INSERT INTO `t_blog` VALUES (72, '“民族主义的能源政策”', '如题', 7);
INSERT INTO `t_blog` VALUES (73, '新美人鱼发了部分剧照，我改了下顺序成了另一个故事 ', '如题', 8);
INSERT INTO `t_blog` VALUES (74, '	很奇妙啊，明明《龙与地下城》完成度更高 ', '如题', 9);
INSERT INTO `t_blog` VALUES (75, '窦唯只有黑梦 希望之光还有黑豹乐队那一段时间的歌是摇滚的', '如题', 10);
INSERT INTO `t_blog` VALUES (76, '曼达洛人第三季就是坨屎啊', '如题', 11);
INSERT INTO `t_blog` VALUES (77, '凭什么龙与地下城票房这么低啊？？', '如题', 12);
INSERT INTO `t_blog` VALUES (78, '新海诚足控是自己承认的啊，你可以选择不看', '如题', 13);
INSERT INTO `t_blog` VALUES (79, '很不喜欢铃芽之旅的性暗示', '这电影不止一次让我想到了《哈尔的移动城堡》,我觉得各种性元素不是不能有，但是要为了内容和情感表达服务', 14);
INSERT INTO `t_blog` VALUES (80, '本来无一物，何处惹尘埃？', '如题', 15);
INSERT INTO `t_blog` VALUES (81, '妈妈我爱你', '就像在草原上奔腾的野狗', 16);
INSERT INTO `t_blog` VALUES (82, '我是谁?', '谁能告诉我吗?', 8);
INSERT INTO `t_blog` VALUES (83, '​极速追杀4有一种数值的美，得亏有叶师傅', '叶师傅的打戏太帅了，把盲人这个设定和动作结合的很好\r\n囧威客就是纯纯的数值怪了，就像看lol操作秀里蹦出来一个技能全吃但还是能杀完的片段，不好评价，只能说囧威客神功大成', 8);
INSERT INTO `t_blog` VALUES (91, '三星电子一季度利润血崩', '势头不错,希望继续保持,大家怎么看?', 19);

-- ----------------------------
-- Table structure for t_comment
-- ----------------------------
DROP TABLE IF EXISTS `t_comment`;
CREATE TABLE `t_comment`  (
  `comment_id` int NOT NULL AUTO_INCREMENT,
  `comment_content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `blog_id` int NULL DEFAULT NULL,
  `user_id` int NULL DEFAULT NULL,
  PRIMARY KEY (`comment_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 119 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_comment
-- ----------------------------
INSERT INTO `t_comment` VALUES (1, '一楼是我的', 1, 2);
INSERT INTO `t_comment` VALUES (2, '前排出售瓜子二手车', 1, 2);
INSERT INTO `t_comment` VALUES (3, '一楼沙发', 2, 2);
INSERT INTO `t_comment` VALUES (4, '怎么一个人都没有\r\n什么情况', 2, 2);
INSERT INTO `t_comment` VALUES (5, '没人吗?', 4, 3);
INSERT INTO `t_comment` VALUES (6, '三楼也是我的', 1, 2);
INSERT INTO `t_comment` VALUES (7, '真的要注销吗?不过一楼是我的', 11, 2);
INSERT INTO `t_comment` VALUES (8, '有人,那就是我,但是我马上要注销账号了XD', 4, 2);
INSERT INTO `t_comment` VALUES (9, '啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊', 1, 4);
INSERT INTO `t_comment` VALUES (10, '没什么事,我就想发一条友善的评论~', 3, 4);
INSERT INTO `t_comment` VALUES (11, '一条品论也没有!!', 12, 15);
INSERT INTO `t_comment` VALUES (12, '点击右上角发表一条评论吧!', 12, 15);
INSERT INTO `t_comment` VALUES (13, '一楼,前排沙发', 13, 2);
INSERT INTO `t_comment` VALUES (14, '经验+3', 13, 1);
INSERT INTO `t_comment` VALUES (15, '怎么老有人觉得法国乱一下能动摇马客服的地位啊。。。', 13, 5);
INSERT INTO `t_comment` VALUES (16, '法国总统是全世界权力最大的民选总统，议会根本动不了他一根毛，有民选皇帝之称。\r\n', 13, 5);
INSERT INTO `t_comment` VALUES (17, '都过这么久了,楼上这么还没注销?\r\n', 4, 6);
INSERT INTO `t_comment` VALUES (18, '你发英文鬼看得懂啊', 10, 6);
INSERT INTO `t_comment` VALUES (19, '老馋', 3, 6);
INSERT INTO `t_comment` VALUES (20, '楼上发什么癫', 1, 6);
INSERT INTO `t_comment` VALUES (21, '一楼吃瓜', 14, 2);
INSERT INTO `t_comment` VALUES (22, '1234', 14, 13);
INSERT INTO `t_comment` VALUES (23, '诶,我密码和楼主一样,好巧', 14, 13);
INSERT INTO `t_comment` VALUES (24, '我也是', 14, 7);
INSERT INTO `t_comment` VALUES (25, '这意味着什么?', 14, 7);
INSERT INTO `t_comment` VALUES (26, '有人比我多吗 ? 有人比我多吗 ? 有人比我多吗 ? 有人比我多吗 ? 有人比我多吗 ?', 15, 4);
INSERT INTO `t_comment` VALUES (27, '欧洲除了英国这狗腿子，其他还真没多少能称得上是美国“铁杆盟友”的。', 13, 4);
INSERT INTO `t_comment` VALUES (28, '这意味着你们都是脑瘫', 14, 4);
INSERT INTO `t_comment` VALUES (29, '有没有管理员?我想试试被封的感觉', 14, 4);
INSERT INTO `t_comment` VALUES (30, '感觉不如......平壤', 6, 4);
INSERT INTO `t_comment` VALUES (31, '2楼前排经验+3', 6, 2);
INSERT INTO `t_comment` VALUES (32, '中专吗? 错别字会这么多?', 12, 2);
INSERT INTO `t_comment` VALUES (33, '一楼是我的吗', 16, 2);
INSERT INTO `t_comment` VALUES (34, '还真是', 16, 2);
INSERT INTO `t_comment` VALUES (35, 'Hello ! 酷狗 !', 1, 14);
INSERT INTO `t_comment` VALUES (36, '里斯本其实也不是什么好地方', 5, 14);
INSERT INTO `t_comment` VALUES (37, '对不起发错地方了,呜呜呜', 5, 14);
INSERT INTO `t_comment` VALUES (38, '我这就销号', 5, 14);
INSERT INTO `t_comment` VALUES (39, '什么玩意', 5, 9);
INSERT INTO `t_comment` VALUES (40, '撑死二线中下游或者三线前列', 6, 9);
INSERT INTO `t_comment` VALUES (41, '话说你这标题和内容有半毛钱联系吗', 6, 9);
INSERT INTO `t_comment` VALUES (42, '我的是85787895', 14, 2);
INSERT INTO `t_comment` VALUES (43, '看过水浒没有，梁山的第一次招安差不多的样子', 13, 2);
INSERT INTO `t_comment` VALUES (44, '马克龙已经是连任两届了,这养老金改革彻底毁了他. 冯表就不说了', 13, 2);
INSERT INTO `t_comment` VALUES (45, '我们和空客还有个合同在谈判，马客服来了估计也是因为这事谈的可能快差不多了', 13, 2);
INSERT INTO `t_comment` VALUES (46, '马宁儿带着冯锡范，前来要饭！', 13, 2);
INSERT INTO `t_comment` VALUES (47, '顺便十楼是我的 !!!', 13, 2);
INSERT INTO `t_comment` VALUES (48, '虽然每日乳法，但相比欧盟内其他能排的上号的国家，起码是真的有拿得出手的完整军工体系。', 13, 8);
INSERT INTO `t_comment` VALUES (49, 'ABCDEFG', 13, 8);
INSERT INTO `t_comment` VALUES (50, '我感觉不该给马克龙和那个女人面子', 13, 8);
INSERT INTO `t_comment` VALUES (51, '谈谈无妨，只要对方不自取其辱，作为大国没必要带那么强的敌意', 13, 10);
INSERT INTO `t_comment` VALUES (52, '宰相肚里能撑船啊', 13, 10);
INSERT INTO `t_comment` VALUES (53, '能谈就谈，不能谈最多浪费点时间，这次接待也是给其他观望的国家释放一点信号，只要不头铁都可以', 13, 10);
INSERT INTO `t_comment` VALUES (54, '来了属于是面子给了，费事听你们以后嚼口舌，剩下就是看小丑罢了', 13, 4);
INSERT INTO `t_comment` VALUES (55, '不急，先跟他耍耍哭笑', 13, 4);
INSERT INTO `t_comment` VALUES (56, '也可以认为是贾诩劝张秀降曹操的逻辑', 13, 1);
INSERT INTO `t_comment` VALUES (57, '哪怕是让马客服认清楚有9个孩子的妈这种孙尚香盯着啥事都给你整砸咯的现实也是好事', 13, 1);
INSERT INTO `t_comment` VALUES (58, '区别对待就好了\r\n冯老女表，让她滚一边去', 13, 1);
INSERT INTO `t_comment` VALUES (59, '1条评论', 13, 2);
INSERT INTO `t_comment` VALUES (60, '2条评论', 13, 2);
INSERT INTO `t_comment` VALUES (61, '3条评论', 13, 2);
INSERT INTO `t_comment` VALUES (62, '4条评论', 13, 2);
INSERT INTO `t_comment` VALUES (63, '发国面子肯定要给的。。。', 13, 2);
INSERT INTO `t_comment` VALUES (64, '主不可怒而兴师，将不可愠而致战。', 13, 5);
INSERT INTO `t_comment` VALUES (65, '对于马克龙，给法国个面子，也不亏什么。没必要现在就甩大国脸色。', 13, 5);
INSERT INTO `t_comment` VALUES (66, '法国在欧洲还有话语权，也是五常，马克龙也愿意低姿态，给个面子没问题', 13, 5);
INSERT INTO `t_comment` VALUES (67, '冯德莱恩就没必要了。上面比你清楚，你看通报是不是邀请', 13, 5);
INSERT INTO `t_comment` VALUES (68, '法国都迈出用人民币做交易的第一步了，面子还是得给的', 13, 6);
INSERT INTO `t_comment` VALUES (69, '暂时还没到用“我蛮夷也”这张牌的时候', 13, 6);
INSERT INTO `t_comment` VALUES (70, '法国才跟你搞完第一笔人民币交易\r\n给个面子多少应该的\r\n但是这面子是给马克龙的 不是给疯的莱恩的', 13, 6);
INSERT INTO `t_comment` VALUES (71, '主要是维护自身国际形象，告诉各国“只要你愿意来谈，我随时欢迎”。', 13, 15);
INSERT INTO `t_comment` VALUES (72, '小马的面子还是可以给的，就看他自己接不接的住', 13, 15);
INSERT INTO `t_comment` VALUES (73, '为了发这条评论,我专门注册了这个账号', 13, 16);
INSERT INTO `t_comment` VALUES (74, '你能想到这上面想不到么哈哈哈', 13, 2);
INSERT INTO `t_comment` VALUES (75, '就算他一点用都没有但是姿态还是要给的\r\n\r\n你老二时都这么牛逼了当了老大还得了？', 13, 2);
INSERT INTO `t_comment` VALUES (76, '今天东方卫视新闻，马克龙有下飞机的画面并着重介绍', 13, 9);
INSERT INTO `t_comment` VALUES (77, '老太婆就是一句话带过，没有任何画面', 13, 9);
INSERT INTO `t_comment` VALUES (78, '马和冯并非同机抵达', 13, 9);
INSERT INTO `t_comment` VALUES (79, '法国都已经掺和进阿鹅兔三家的本币天然气结算了，你确定不给马客服这个面子么？', 13, 9);
INSERT INTO `t_comment` VALUES (81, '前排', 7, 2);
INSERT INTO `t_comment` VALUES (82, 'Are you 李磊 ?', 6, 19);
INSERT INTO `t_comment` VALUES (83, 'Time for a true display of skills', 91, 19);
INSERT INTO `t_comment` VALUES (84, 'Tonight, we hunt.', 91, 19);
INSERT INTO `t_comment` VALUES (85, 'Welcome to the league of Driven.', 91, 19);
INSERT INTO `t_comment` VALUES (86, 'Let\'s get into the fight !', 91, 19);
INSERT INTO `t_comment` VALUES (92, '123456789555555555555', 10, 2);
INSERT INTO `t_comment` VALUES (107, '建政稍许就好, 别搞太敏感的东西', 13, 21);
INSERT INTO `t_comment` VALUES (108, '不然就把你们都鲨喽', 13, 21);
INSERT INTO `t_comment` VALUES (109, '楼上狗叫? 敢封我?', 13, 22);
INSERT INTO `t_comment` VALUES (110, '经验加三', 13, 2);
INSERT INTO `t_comment` VALUES (111, '好似, 开香槟喽', 13, 5);
INSERT INTO `t_comment` VALUES (112, '有人晚上要点外卖吗', 13, 5);
INSERT INTO `t_comment` VALUES (113, '不是说好今天20度的吗', 5, 4);
INSERT INTO `t_comment` VALUES (114, '谁说的你找谁去', 5, 10);
INSERT INTO `t_comment` VALUES (115, '好像就是楼主说的', 5, 7);
INSERT INTO `t_comment` VALUES (116, '前排沙发,经验 + 3', 5, 2);
INSERT INTO `t_comment` VALUES (117, 'Screw you, dump ass.', 5, 6);
INSERT INTO `t_comment` VALUES (118, '我是管理员, 我也不知道这意味这什么', 5, 0);

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 24 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES (0, 'admin', 'admin');
INSERT INTO `t_user` VALUES (1, 'Billy_real', '123456');
INSERT INTO `t_user` VALUES (2, 'ENKEPHALIN', '85787895');
INSERT INTO `t_user` VALUES (3, 'ABCD', '1234');
INSERT INTO `t_user` VALUES (4, 'Anemo', '1234');
INSERT INTO `t_user` VALUES (5, 'geo_archon', '1234');
INSERT INTO `t_user` VALUES (6, 'Electro', '1234');
INSERT INTO `t_user` VALUES (7, 'Dendro', '1234');
INSERT INTO `t_user` VALUES (8, 'Hydro', '1234');
INSERT INTO `t_user` VALUES (9, 'Pyro', '1234');
INSERT INTO `t_user` VALUES (10, 'Cryo', '1234');
INSERT INTO `t_user` VALUES (11, 'NOPE', '1234');
INSERT INTO `t_user` VALUES (12, 'Yepper', '1234');
INSERT INTO `t_user` VALUES (13, 'OvO', '1234');
INSERT INTO `t_user` VALUES (15, 'Snezhnaya', '1234');
INSERT INTO `t_user` VALUES (16, 'Mondstadt', '1234');
INSERT INTO `t_user` VALUES (17, 'Fontaine', '1234');
INSERT INTO `t_user` VALUES (23, 'bbbb', 'bbbb');

SET FOREIGN_KEY_CHECKS = 1;
