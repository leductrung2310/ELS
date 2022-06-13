package com.example.els.view.personal;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.els.R;
import com.example.els.adapter.home.GrammarAdapter;
import com.example.els.databinding.FragmentNewspaperBinding;
import com.example.els.models.Grammar;
import com.example.els.viewmodel.home.GrammarViewModel;
import com.example.els.viewmodel.home.HomeViewModel;

import java.util.ArrayList;
import java.util.List;

public class NewspaperFragment extends Fragment  implements GrammarAdapter.OnLessonItemListener {
    private FragmentNewspaperBinding binding;
    private GrammarViewModel grammarViewModel;
    private  ArrayList<Grammar> grammars;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentNewspaperBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        grammarViewModel= new ViewModelProvider(requireActivity()).get(GrammarViewModel.class);

        binding.personalNewspaperBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_newspaperFragment_to_homeFragment);
            }
        });

        grammars = new ArrayList<>();
        grammars.add(new Grammar("Cấu trúc chung của một câu", "<!DOCTYPE html>\n" +
                "<html>\n" +
                "\t<head>\n" +
                "\t\t<meta charset=\"UTF-8\">\n" +
                "\t\t<title>Ngữ Pháp Tiếng Anh</title>\n" +
                "\t\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\"> \t\t\n" +
                "\t</head>\n" +
                "\t<body style=\"font-size:13px; text-align:justify\">\n" +
                "<h3><span style=\"color: #0070c0;\"><a name=\"1\">1</a>. Cấu tr&uacute;c chung của một c&acirc;u:</span></h3>\n" +
                "<p>Một c&acirc;u trong tiếng Anh thường bao gồm c&aacute;c th&agrave;nh phần sau đ&acirc;y:</p>\n" +
                "<p style=\"text-align: center;\"><strong><span style=\"color: #c00000;\">SUBJECT - VERT - COMPLEMENT - MODIFIER</span></strong></p>\n" +
                "<p>V&iacute; dụ:</p>\n" +
                "<table border=\"1\" width=\"100%\">\n" +
                "    <tbody>\n" +
                "        <tr>\n" +
                "            <td align=\"center\" style=\"width: 157px;\"><strong>SUBJECT</strong></td>\n" +
                "            <td align=\"center\" style=\"width: 157px;\"><strong>VERB</strong></td>\n" +
                "            <td align=\"center\" style=\"width: 156px;\"><strong>COMPLEMENT</strong></td>\n" +
                "            <td align=\"center\" style=\"width: 156px;\"><strong>MODIFIER</strong></td>\n" +
                "        </tr>\n" +
                "        <tr>\n" +
                "            <td align=\"center\" style=\"width: 157px;\">John and I</td>\n" +
                "            <td align=\"center\" style=\"width: 157px;\">ate</td>\n" +
                "            <td align=\"center\" style=\"width: 156px;\">a pizza</td>\n" +
                "            <td align=\"center\" style=\"width: 156px;\">last night.</td>\n" +
                "        </tr>\n" +
                "        <tr>\n" +
                "            <td align=\"center\" style=\"width: 157px;\">We</td>\n" +
                "            <td align=\"center\" style=\"width: 157px;\">studied</td>\n" +
                "            <td align=\"center\" style=\"width: 156px;\">\"present perfect\"</td>\n" +
                "            <td align=\"center\" style=\"width: 156px;\">last week.</td>\n" +
                "        </tr>\n" +
                "        <tr>\n" +
                "            <td align=\"center\" style=\"width: 157px;\">He</td>\n" +
                "            <td align=\"center\" style=\"width: 157px;\">runs</td>\n" +
                "            <td align=\"center\" style=\"width: 156px;\">&nbsp;</td>\n" +
                "            <td align=\"center\" style=\"width: 156px;\">very fast.</td>\n" +
                "        </tr>\n" +
                "        <tr>\n" +
                "            <td align=\"center\" style=\"width: 157px;\">I</td>\n" +
                "            <td align=\"center\" style=\"width: 157px;\">like</td>\n" +
                "            <td align=\"center\" style=\"width: 156px;\">walking.</td>\n" +
                "            <td align=\"center\" style=\"width: 156px;\">&nbsp;</td>\n" +
                "        </tr>\n" +
                "    </tbody>\n" +
                "</table>\n" +
                "<h3><span style=\"color: #0070c0;\"><a name=\"1.1\">1.1</a>&nbsp;Subject (chủ ngữ):</span></h3>\n" +
                "<p>Chủ ngữ l&agrave; chủ thể của h&agrave;nh động trong c&acirc;u, thường đứng trước động từ (verb). Chủ ngữ thường l&agrave; một danh từ (noun) hoặc một ngữ danh từ (noun phrase - một nh&oacute;m từ kết th&uacute;c bằng một danh từ, trong trường hợp n&agrave;y ngữ danh từ kh&ocirc;ng được bắt đầu bằng một giới từ). Chủ ngữ thường đứng ở đầu c&acirc;u v&agrave; quyết định việc chia động từ.&nbsp;<br />\n" +
                "<br />\n" +
                "Ch&uacute; &yacute; rằng mọi c&acirc;u trong tiếng Anh đều c&oacute; chủ ngữ (Trong c&acirc;u mệnh lệnh, chủ ngữ được ngầm hiểu l&agrave; người nghe. V&iacute; dụ: &ldquo;Don't move!&rdquo; = Đứng im!).<br />\n" +
                "<br />\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;<span style=\"text-decoration: underline;\">Milk</span>&nbsp;is delicious. (một danh từ)<br />\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;<span style=\"text-decoration: underline;\">That new, red car</span>&nbsp;is mine. (một ngữ danh từ)&nbsp;<br />\n" +
                "<br />\n" +
                "Đ&ocirc;i khi c&acirc;u kh&ocirc;ng c&oacute; chủ ngữ thật sự, trong trường hợp đ&oacute;,&nbsp;<em>It</em>&nbsp;hoặc&nbsp;<em>There</em>&nbsp;đ&oacute;ng vai tr&ograve; chủ ngữ giả.<br />\n" +
                "<br />\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;<span style=\"text-decoration: underline;\">It</span>&nbsp;is a nice day today.<br />\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;<span style=\"text-decoration: underline;\">There</span>&nbsp;are a fire in that building.<br />\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;<span style=\"text-decoration: underline;\">There</span>&nbsp;were many students in the room.<br />\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;<span style=\"text-decoration: underline;\">It</span>&nbsp;is the fact that the earth goes around the sun.</p>\n" +
                "<h3><span style=\"color: #0070c0;\"><a name=\"1.2\">1.2</a>&nbsp;Verb (động từ):</span></h3>\n" +
                "<p>Động từ l&agrave; từ chỉ h&agrave;nh động hoặc trạng th&aacute;i của chủ ngữ. Mọi c&acirc;u đều phải c&oacute; động từ. N&oacute; c&oacute; thể l&agrave; một từ đơn hoặc một ngữ động từ. Ngữ động từ (verb phrase) l&agrave; một nh&oacute;m từ gồm một hoặc nhiều trợ động từ (auxiliary) v&agrave; một động từ ch&iacute;nh.<br />\n" +
                "<br />\n" +
                "&nbsp;&nbsp;&nbsp; I&nbsp;<span style=\"text-decoration: underline;\">love</span>&nbsp;you. (chỉ h&agrave;nh động)<br />\n" +
                "&nbsp;&nbsp;&nbsp; Chilli&nbsp;<span style=\"text-decoration: underline;\">is</span>&nbsp;hot. (chỉ trạng th&aacute;i)<br />\n" +
                "&nbsp;&nbsp;&nbsp; I&nbsp;<span style=\"text-decoration: underline;\">have seen</span>&nbsp;the movie three times before. (auxiliary: have; main verb: seen)<br />\n" +
                "&nbsp;&nbsp;&nbsp; I&nbsp;<span style=\"text-decoration: underline;\">am going</span>&nbsp;to Sai Gon tomorrow. (auxiliary: am; main verb: going)</p>\n" +
                "<h3><span style=\"color: #0070c0;\"><a name=\"1.3\">1.3</a>&nbsp;Complement (vị ngữ):</span></h3>\n" +
                "<p>Vị ngữ l&agrave; từ hoặc cụm từ chỉ đối tượng t&aacute;c động của chủ ngữ. Cũng giống như chủ ngữ, vị ngữ thường l&agrave; danh từ hoặc ngữ danh từ kh&ocirc;ng bắt đầu bằng giới từ, tuy nhi&ecirc;n vị ngữ thường đứng sau động từ. Kh&ocirc;ng phải c&acirc;u n&agrave;o cũng c&oacute; complement. Vị ngữ trả lời cho c&acirc;u hỏi What? hoặc Whom?<br />\n" +
                "<br />\n" +
                "&nbsp;&nbsp;&nbsp; John bought&nbsp;<span style=\"text-decoration: underline;\">a car</span>&nbsp;yesterday. (What did John buy?)<br />\n" +
                "&nbsp;&nbsp;&nbsp; Jill wants to drink&nbsp;<span style=\"text-decoration: underline;\">some water</span>. (What does he want to drink?)<br />\n" +
                "&nbsp;&nbsp;&nbsp; She saw&nbsp;<span style=\"text-decoration: underline;\">John</span>&nbsp;at the movie last night. (Whom did she see at the movie?)</p>\n" +
                "<h3><span style=\"color: #0070c0;\"><a name=\"1.4\">1.4</a>&nbsp;Modifier (trạng từ):</span></h3>\n" +
                "<p>Trạng từ l&agrave; từ hoặc cụm từ chỉ thời gian, địa điểm hoặc c&aacute;ch thức của h&agrave;nh động. Kh&ocirc;ng phải c&acirc;u n&agrave;o cũng c&oacute; trạng từ. Ch&uacute;ng thường l&agrave; c&aacute;c cụm giới từ (prepositional phrase), ph&oacute; từ (adverb) hoặc một cụm ph&oacute; từ (adverbial phrase). Ch&uacute;ng trả lời c&acirc;u hỏi When?, Where? hoặc How? Một cụm giới từ l&agrave; một cụm từ bắt đầu bằng một giới từ v&agrave; kết th&uacute;c bằng một danh từ (VD: in the morning, on the table,...). Nếu c&oacute; nhiều trạng từ trong c&acirc;u th&igrave; trạng từ chỉ thời gian thường đi sau c&ugrave;ng.<br />\n" +
                "<br />\n" +
                "&nbsp;&nbsp;&nbsp; John bought a book&nbsp;<span style=\"text-decoration: underline;\">at the bookstore</span>. (Where did John buy a book?)<br />\n" +
                "&nbsp;&nbsp;&nbsp; She saw John&nbsp;<span style=\"text-decoration: underline;\">at the movie</span>&nbsp;<span style=\"text-decoration: underline;\">last night</span>. (Where did she see John? When did she see him?)<br />\n" +
                "&nbsp;&nbsp;&nbsp; She drives&nbsp;<span style=\"text-decoration: underline;\">very fast</span>. (How does she drive?)<br />\n" +
                "<br />\n" +
                "Ch&uacute; &yacute; rằng trạng từ thường đi sau vị ngữ nhưng kh&ocirc;ng nhất thiết. Tuy nhi&ecirc;n trạng từ l&agrave; cụm giới từ kh&ocirc;ng được nằm giữa động từ v&agrave; vị ngữ.</p>\n" +
                "<p>&nbsp;&nbsp;&nbsp; She&nbsp;<span style=\"text-decoration: underline;\">drove</span>&nbsp;<em>on the street</em>&nbsp;<span style=\"text-decoration: underline;\">her new car</span>. (Sai)<br />\n" +
                "&nbsp;&nbsp;&nbsp; She&nbsp;<span style=\"text-decoration: underline;\">drove</span>&nbsp;<span style=\"text-decoration: underline;\">her new car</span>&nbsp;<em>on the street</em>. (Đ&uacute;ng)<br />\n" +
                "<br />\n" +
                "<br />\n" +
                "</p>\n" +
                "\n" +
                "\t</body>\n" +
                "</html>"));
        grammars.add(new Grammar("Noun phrase (ngữ danh từ)", "<!DOCTYPE html>\n" +
                "<html>\n" +
                "\t<head>\n" +
                "\t\t<meta charset=\"UTF-8\">\n" +
                "\t\t<title>Ngữ Pháp Tiếng Anh</title>\n" +
                "\t\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\"> \t\t\n" +
                "\t</head>\n" +
                "\t<body style=\"font-size:13px; text-align:justify\">\n" +
                "<h3><span style=\"color: #4f81bd;\"><a name=\"2\">2</a>. Noun phrase (ngữ danh từ)</span></h3>\n" +
                "<h3><span style=\"color: #0070c0;\"><a name=\"2.1\">2.1</a>&nbsp;Danh từ đếm được v&agrave; kh&ocirc;ng đếm được (Count noun/ Non-count noun):</span></h3>\n" +
                "<p>&middot;&nbsp;<strong>Danh từ đếm được</strong>: L&agrave; danh từ c&oacute; thể d&ugrave;ng được với số đếm, do đ&oacute; n&oacute; c&oacute; 2 h&igrave;nh th&aacute;i số &iacute;t v&agrave; số nhiều. N&oacute; d&ugrave;ng được với&nbsp;<em>a</em>&nbsp;hay với&nbsp;<em>the</em>. VD: one book, two books, ...&nbsp;<br />\n" +
                "<br />\n" +
                "&middot;&nbsp;<strong>Danh từ kh&ocirc;ng đếm được</strong>: Kh&ocirc;ng d&ugrave;ng được với số đếm, do đ&oacute; n&oacute; kh&ocirc;ng c&oacute; h&igrave;nh th&aacute;i số &iacute;t, số nhiều. N&oacute; kh&ocirc;ng thể d&ugrave;ng được với&nbsp;<em>a</em>, c&ograve;n&nbsp;<em>the</em>&nbsp;chỉ trong một số trường hợp đặc biệt. VD: milk (sữa). Bạn kh&ocirc;ng thể n&oacute;i \"one milk\", \"two milks\" ... (Một số vật chất kh&ocirc;ng đếm được c&oacute; thể được chứa trong c&aacute;c b&igrave;nh đựng, bao b&igrave;... đếm được. VD: one glass of milk - một cốc sữa).&nbsp;<br />\n" +
                "<br />\n" +
                "&middot; Một số danh từ đếm được c&oacute; h&igrave;nh th&aacute;i số nhiều đặc biệt. VD: person - people; child - children; tooth &ndash; teeth; foot &ndash; feet; mouse &ndash; mice ...&nbsp;<br />\n" +
                "<br />\n" +
                "&middot; Một số danh từ đếm được c&oacute; dạng số &iacute;t/ số nhiều như nhau chỉ ph&acirc;n biệt bằng c&oacute; \"a\" v&agrave; kh&ocirc;ng c&oacute; \"a\":&nbsp;<br />\n" +
                "an aircraft/ aircraft; a sheep/ sheep; a fish/ fish.&nbsp;<br />\n" +
                "<br />\n" +
                "&middot; Một số c&aacute;c danh từ kh&ocirc;ng đếm được như food, meat, money, sand, water ... đ&ocirc;i khi được d&ugrave;ng như c&aacute;c danh từ số nhiều để chỉ c&aacute;c dạng, loại kh&aacute;c nhau của vật liệu đ&oacute;.&nbsp;<br />\n" +
                "<br />\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; This is&nbsp;<span style=\"text-decoration: underline;\">one of the foods</span>&nbsp;that my doctor wants me to eat.&nbsp;<br />\n" +
                "<br />\n" +
                "&middot; Danh từ \"time\" nếu d&ugrave;ng với nghĩa l&agrave; \"thời gian\" l&agrave; kh&ocirc;ng đếm được nhưng khi d&ugrave;ng với nghĩa l&agrave; \"thời đại\" hay \"số lần\" l&agrave; danh từ đếm được.&nbsp;<br />\n" +
                "<br />\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; You have spent too much&nbsp;<span style=\"text-decoration: underline;\">time</span>&nbsp;on that homework. (thời gian, kh&ocirc;ng đếm được)<br />\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; I have seen that movie three&nbsp;<span style=\"text-decoration: underline;\">times</span>&nbsp;before. (số lần, đếm được)</p>\n" +
                "<p><strong>Bảng sau l&agrave; c&aacute;c định ngữ d&ugrave;ng được với c&aacute;c danh từ đếm được v&agrave; kh&ocirc;ng đếm được.</strong></p>\n" +
                "<table border=\"1\" width=\"100%\">\n" +
                "    <tbody>\n" +
                "        <tr>\n" +
                "            <td style=\"width: 319px;\">WITH COUNT NOUN&nbsp;</td>\n" +
                "            <td style=\"width: 319px;\">WITH NON-COUNT NOUN</td>\n" +
                "        </tr>\n" +
                "        <tr>\n" +
                "            <td style=\"width: 319px;\">a(n), the, some, any&nbsp;</td>\n" +
                "            <td style=\"width: 319px;\">the, some, any&nbsp;</td>\n" +
                "        </tr>\n" +
                "        <tr>\n" +
                "            <td style=\"width: 319px;\">this, that, these, those&nbsp;</td>\n" +
                "            <td style=\"width: 319px;\">this, that&nbsp;</td>\n" +
                "        </tr>\n" +
                "        <tr>\n" +
                "            <td style=\"width: 319px;\">none, one, two, three,...&nbsp;</td>\n" +
                "            <td style=\"width: 319px;\">None&nbsp;</td>\n" +
                "        </tr>\n" +
                "        <tr>\n" +
                "            <td style=\"width: 319px;\">many&nbsp;<br />\n" +
                "            a lot of&nbsp;<br />\n" +
                "            a [large / great]&nbsp;<span style=\"text-decoration: underline;\">number of</span>&nbsp;<br />\n" +
                "            (a) few&nbsp;<br />\n" +
                "            <span style=\"text-decoration: underline;\">fewer</span>... than&nbsp;<br />\n" +
                "            more....than</td>\n" +
                "            <td style=\"width: 319px;\">much (thường d&ugrave;ng trong c&acirc;u phủ định, c&acirc;u hỏi)&nbsp;<br />\n" +
                "            a lot of&nbsp;<br />\n" +
                "            a large&nbsp;<span style=\"text-decoration: underline;\">amount of</span><br />\n" +
                "            (a) little&nbsp;<br />\n" +
                "            <span style=\"text-decoration: underline;\">less</span>....than&nbsp;<br />\n" +
                "            more....than</td>\n" +
                "        </tr>\n" +
                "    </tbody>\n" +
                "</table>\n" +
                "<p><strong>Một số từ kh&ocirc;ng đếm được n&ecirc;n biết:</strong></p>\n" +
                "<table border=\"0\" width=\"100%\">\n" +
                "    <tbody>\n" +
                "        <tr>\n" +
                "            <td style=\"width: 157px;\">sand<br />\n" +
                "            food<br />\n" +
                "            meat<br />\n" +
                "            water</td>\n" +
                "            <td style=\"width: 158px;\">money<br />\n" +
                "            news<br />\n" +
                "            measles (bệnh sởi)<br />\n" +
                "            soap&nbsp;</td>\n" +
                "            <td style=\"width: 158px;\">information<br />\n" +
                "            air<br />\n" +
                "            mumps (bệnh quai bị)<br />\n" +
                "            economics</td>\n" +
                "            <td style=\"width: 158px;\">physics<br />\n" +
                "            mathematics<br />\n" +
                "            politics<br />\n" +
                "            homework</td>\n" +
                "        </tr>\n" +
                "    </tbody>\n" +
                "</table>\n" +
                "<p>Note:&nbsp;<em>advertising</em>&nbsp;l&agrave; danh từ kh&ocirc;ng đếm được nhưng&nbsp;<em>advertisement</em>&nbsp;l&agrave; danh từ đếm được, chỉ một quảng c&aacute;o cụ thể n&agrave;o đ&oacute;.&nbsp;<br />\n" +
                "<br />\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; There are too many&nbsp;<span style=\"text-decoration: underline;\">advertisements</span>&nbsp;during TV shows.</p>\n" +
                "<h3><span style=\"color: #0070c0;\"><a name=\"2.2\">2.2</a>&nbsp;C&aacute;ch d&ugrave;ng qu&aacute;n từ kh&ocirc;ng x&aacute;c định \"a\" v&agrave; \"an\"</span></h3>\n" +
                "<p>D&ugrave;ng a hoặc an trước một danh từ số &iacute;t đếm được. Ch&uacute;ng c&oacute; nghĩa l&agrave; một. Ch&uacute;ng được d&ugrave;ng trong c&acirc;u c&oacute; t&iacute;nh kh&aacute;i qu&aacute;t hoặc đề cập đến một chủ thể chưa được đề cập từ trước.<br />\n" +
                "<br />\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span style=\"text-decoration: underline;\">A ball</span>&nbsp;is round. (nghĩa chung, kh&aacute;i qu&aacute;t, chỉ tất cả c&aacute;c quả b&oacute;ng)<br />\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; I saw&nbsp;<span style=\"text-decoration: underline;\">a boy</span>&nbsp;in the street. (ch&uacute;ng ta kh&ocirc;ng biết cậu b&eacute; n&agrave;o, chưa được đề cập trước đ&oacute;)</p>\n" +
                "<h4><span style=\"color: #0070c0;\"><a name=\"2.2.1\">2.2.1</a>&nbsp;D&ugrave;ng &ldquo;an&rdquo; với:</span></h4>\n" +
                "<p>Qu&aacute;n từ&nbsp;<em>an</em>&nbsp;được d&ugrave;ng trước từ bắt đầu bằng nguy&ecirc;n &acirc;m (trong c&aacute;ch ph&aacute;t &acirc;m, chứ kh&ocirc;ng phải trong c&aacute;ch viết). Bao gồm:<br />\n" +
                "<br />\n" +
                "&middot; C&aacute;c từ bắt đầu bằng c&aacute;c nguy&ecirc;n &acirc;m a, e, i, o: an aircraft, an empty glass, an object&nbsp;<br />\n" +
                "&middot; Một số từ bắt đầu bằng u, y: an uncle, an umbrella&nbsp;<br />\n" +
                "&middot; Một số từ bắt đầu bằng h c&acirc;m: an heir, haft an hour&nbsp;&nbsp;<br />\n" +
                "&middot; C&aacute;c từ mở đầu bằng một chữ viết tắt: an S.O.S/ an M.P</p>\n" +
                "<h4><span style=\"color: #0070c0;\"><a name=\"2.2.2\">2.2.2</a>&nbsp;D&ugrave;ng &ldquo;a&rdquo; với:</span></h4>\n" +
                "<p>D&ugrave;ng&nbsp;<em>a</em>&nbsp;trước c&aacute;c từ bắt đầu bằng một phụ &acirc;m. Ch&uacute;ng bao gồm c&aacute;c chữ c&aacute;i c&ograve;n lại v&agrave; một số trường hợp bắt đầu bằng u, y, h. VD: a house, a university, a home party, a heavy load, a uniform, a union, a year income,...<br />\n" +
                "<br />\n" +
                "&middot; Đứng trước một danh từ mở đầu bằng \"uni...\" phải d&ugrave;ng \"a\" (a university/ a uniform/ universal/ union) (Europe, eulogy (lời ca ngợi), euphemism (lối n&oacute;i trại), eucalyptus (c&acirc;y khuynh diệp)&nbsp;<br />\n" +
                "&middot; D&ugrave;ng trong c&aacute;c th&agrave;nh ngữ chỉ số lượng nhất định như: a lot of/a great deal of/a couple/a dozen.&nbsp;&nbsp;<br />\n" +
                "&middot; D&ugrave;ng trước những số đếm nhất định thường l&agrave; h&agrave;ng ng&agrave;n, h&agrave;ng trăm như a/one hundred - a/one thousand.&nbsp;&nbsp;<br />\n" +
                "&middot; D&ugrave;ng trước \"half\" (một nửa) khi n&oacute; theo sau một đơn vị nguy&ecirc;n vẹn: a kilo and a half, hay khi n&oacute; đi gh&eacute;p với một danh từ kh&aacute;c để chỉ nửa phần (khi viết c&oacute; dấu gạch nối): a half - share, a half - holiday (ng&agrave;y lễ chỉ nghỉ nửa ng&agrave;y).&nbsp;&nbsp;<br />\n" +
                "&middot; D&ugrave;ng với c&aacute;c đơn vị ph&acirc;n số như 1/3 a/one third - 1/5 a /one fifth.&nbsp;&nbsp;<br />\n" +
                "&middot; D&ugrave;ng trong c&aacute;c th&agrave;nh ngữ chỉ gi&aacute; cả, tốc độ, tỉ lệ: $5 a kilo, 60 kilometers an hour, 4 times a day.&nbsp;</p>\n" +
                "<h3><span style=\"color: #0070c0;\"><a name=\"2.3\">2.3</a>&nbsp;C&aacute;ch d&ugrave;ng qu&aacute;n từ x&aacute;c định \"The\"</span></h3>\n" +
                "<p>D&ugrave;ng&nbsp;<em>the</em>&nbsp;trước một danh từ đ&atilde; được x&aacute;c định cụ thể về mặt t&iacute;nh chất, đặc điểm, vị tr&iacute; hoặc đ&atilde; được đề cập đến trước đ&oacute;, hoặc những kh&aacute;i niệm phổ th&ocirc;ng, ai cũng biết.</p>\n" +
                "<blockquote>\n" +
                "<p><span style=\"text-decoration: underline;\">The boy</span>&nbsp;in the corner is my friend. (Cả người n&oacute;i v&agrave; người nghe đều biết đ&oacute; l&agrave; cậu b&eacute; n&agrave;o)<br />\n" +
                "<span style=\"text-decoration: underline;\">The earth</span>&nbsp;is round. (Chỉ c&oacute; một tr&aacute;i đất, ai cũng biết)</p>\n" +
                "</blockquote>\n" +
                "<p>Với danh từ kh&ocirc;ng đếm được, d&ugrave;ng the nếu n&oacute;i đến một vật cụ thể, kh&ocirc;ng d&ugrave;ng the nếu n&oacute;i chung.<br />\n" +
                "<br />\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Sugar is sweet. (Chỉ c&aacute;c loại đường n&oacute;i chung)<br />\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span style=\"text-decoration: underline;\">The sugar</span>&nbsp;on the table is from Cuba. (Cụ thể l&agrave; đường ở tr&ecirc;n b&agrave;n)<br />\n" +
                "<br />\n" +
                "Với danh từ đếm được số nhiều, khi ch&uacute;ng c&oacute; nghĩa đại diện chung cho một lớp c&aacute;c vật c&ugrave;ng loại th&igrave; cũng kh&ocirc;ng d&ugrave;ng&nbsp;<em>the</em>.<br />\n" +
                "<br />\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span style=\"text-decoration: underline;\">Oranges</span>&nbsp;are green until they ripen. (Cam n&oacute;i chung)<br />\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span style=\"text-decoration: underline;\">Athletes</span>&nbsp;should follow a well-balanced diet. (Vận động vi&ecirc;n n&oacute;i chung)</p>\n" +
                "<h4><span style=\"color: #0070c0;\"><a name=\"2.3.1\">2.3.1</a>&nbsp;Sau đ&acirc;y l&agrave; một số trường hợp th&ocirc;ng dụng d&ugrave;ng&nbsp;<em>The</em>&nbsp;theo quy tắc tr&ecirc;n:&nbsp;</span></h4>\n" +
                "<p>&middot; The + danh từ + giới từ + danh từ: The girl in blue, the Gulf of Mexico.&nbsp;<br />\n" +
                "&middot; D&ugrave;ng trước những t&iacute;nh từ so s&aacute;nh bậc nhất hoặc only: The only way, the best day.&nbsp;<br />\n" +
                "&middot; D&ugrave;ng cho những khoảng thời gian x&aacute;c định (thập ni&ecirc;n): In the 1990s&nbsp;&nbsp;<br />\n" +
                "&middot; The + danh từ + đại từ quan hệ + mệnh đề phụ: The man to whom you have just spoken is the chairman.&nbsp;<br />\n" +
                "&middot; The + danh từ số &iacute;t tượng trưng cho một nh&oacute;m th&uacute; vật hoặc đồ vật: The whale = whales (lo&agrave;i c&aacute; voi), the deep-freeze (thức ăn đ&ocirc;ng lạnh)&nbsp;&nbsp;<br />\n" +
                "&middot; Đối với&nbsp;<em>man</em>&nbsp;khi mang nghĩa \"lo&agrave;i người\" tuyệt đối kh&ocirc;ng được d&ugrave;ng the: Since man lived on the earth ... (kể từ khi lo&agrave;i người sinh sống tr&ecirc;n tr&aacute;i đất n&agrave;y)&nbsp;&nbsp;<br />\n" +
                "&middot; D&ugrave;ng trước một danh từ số &iacute;t để chỉ một nh&oacute;m, một hạng người nhất định trong x&atilde; hội: The small shopkeeper: Giới chủ tiệm nhỏ/ The top offcial: Giới quan chức cao cấp&nbsp;&nbsp;<br />\n" +
                "&middot; The + adj: Tượng trưng cho một nh&oacute;m người, ch&uacute;ng kh&ocirc;ng bao giờ được ph&eacute;p ở số nhiều nhưng được xem l&agrave; c&aacute;c danh từ số nhiều. Do vậy động từ v&agrave; đại từ đi c&ugrave;ng với ch&uacute;ng phải ở ng&ocirc;i thứ 3 số nhiều: The old = The old people;<br />\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span style=\"text-decoration: underline;\">The old</span>&nbsp;<em>are</em>&nbsp;often very hard in their moving&nbsp;&nbsp;<br />\n" +
                "&middot; The + t&ecirc;n gọi c&aacute;c đội hợp xướng/ d&agrave;n nhạc cổ điển/ ban nhạc phổ th&ocirc;ng: The Back Choir/ The Philharmonique Philadelphia Orchestra/ The Beatles.&nbsp;&nbsp;<br />\n" +
                "&middot; The + t&ecirc;n gọi c&aacute;c tờ b&aacute;o (kh&ocirc;ng tạp ch&iacute;)/ t&agrave;u biển/ c&aacute;c khinh kh&iacute; cầu: The Times/ The Titanic/ The Hindenberg&nbsp;&nbsp;<br />\n" +
                "&middot; The + họ của một gia đ&igrave;nh ở số nhiều =&nbsp;<em>gia đ&igrave;nh nh&agrave;</em>: The Smiths = Mr/ Mrs Smith and children&nbsp;&nbsp;<br />\n" +
                "&middot; Th&ocirc;ng thường kh&ocirc;ng d&ugrave;ng the trước t&ecirc;n ri&ecirc;ng trừ trường hợp c&oacute; nhiều người hoặc vật c&ugrave;ng t&ecirc;n v&agrave; người n&oacute;i muốn &aacute;m chỉ một người cụ thể trong số đ&oacute;:&nbsp;<br />\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; There are three Sunsan Parkers in the telephone directory.&nbsp;<span style=\"text-decoration: underline;\">The Sunsan Parker</span>&nbsp;that I know lives on the First Avenue.&nbsp;<br />\n" +
                "&middot; Tương tự, kh&ocirc;ng d&ugrave;ng \"the\" trước bữa ăn: breakfast, lunch, dinner:&nbsp;<br />\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; We ate&nbsp;<span style=\"text-decoration: underline;\">breakfast</span>&nbsp;at 8 am this morning.&nbsp;<br />\n" +
                "Trừ khi muốn &aacute;m chỉ một bữa ăn cụ thể:&nbsp;<br />\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span style=\"text-decoration: underline;\">The dinner</span>&nbsp;that you invited me last week were delecious.&nbsp;&nbsp;<br />\n" +
                "&middot; Kh&ocirc;ng d&ugrave;ng \"the\" trước một số danh từ như home, bed, church, court, jail, prison, hospital, school, class, college, university v.v... khi n&oacute; đi với c&aacute;c động từ v&agrave; giới từ chỉ chuyển động chỉ đi đến đ&oacute; l&agrave; mục đ&iacute;ch ch&iacute;nh hoặc ra khỏi đ&oacute; cũng v&igrave; mục đ&iacute;ch ch&iacute;nh:&nbsp;<br />\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Students go to&nbsp;<span style=\"text-decoration: underline;\">school</span>&nbsp;everyday.<br />\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; The patient was released from&nbsp;<span style=\"text-decoration: underline;\">hospital</span>.&nbsp;<br />\n" +
                "Nhưng nếu đến đ&oacute; hoặc ra khỏi đ&oacute; kh&ocirc;ng v&igrave; mục đ&iacute;ch ch&iacute;nh th&igrave; d&ugrave;ng \"the\".&nbsp;<br />\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Students go to&nbsp;<span style=\"text-decoration: underline;\">the school</span>&nbsp;for a class party.<br />\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; The doctor left&nbsp;<span style=\"text-decoration: underline;\">the hospital</span>&nbsp;for lunch.&nbsp;</p>\n" +
                "<h4 style=\"text-align: left;\"><span style=\"color: #0070c0;\"><a name=\"2.3.2\">2.3.2</a>&nbsp;Bảng sử dụng \"the\" v&agrave; kh&ocirc;ng sử dụng \"the\" trong một số trường hợp điển h&igrave;nh</span></h4>\n" +
                "<table border=\"1\" width=\"100%\">\n" +
                "    <tbody>\n" +
                "        <tr>\n" +
                "            <td style=\"width: 319px;\"><strong>C&oacute; \"The\"&nbsp;</strong></td>\n" +
                "            <td style=\"width: 319px;\"><strong>Kh&ocirc;ng \"The\"&nbsp;</strong></td>\n" +
                "        </tr>\n" +
                "        <tr>\n" +
                "            <td valign=\"top\" style=\"width: 319px;\">+ D&ugrave;ng trước t&ecirc;n c&aacute;c đại dương, s&ocirc;ng ng&ograve;i, biển, vịnh v&agrave; c&aacute;c cụm hồ (số nhiều)<br />\n" +
                "            The Red Sea, the Atlantic Ocean, the Persian Gufl, the Great Lakes&nbsp;\n" +
                "            <p>+ Trước t&ecirc;n c&aacute;c d&atilde;y n&uacute;i:<br />\n" +
                "            The Rocky Mountains&nbsp;<br />\n" +
                "            <br />\n" +
                "            + Trước t&ecirc;n những vật thể duy nhất trong vũ trụ hoặc tr&ecirc;n thế giới:<br />\n" +
                "            The earth, the moon&nbsp;<br />\n" +
                "            <br />\n" +
                "            + The schools, colleges, universities + of + danh từ ri&ecirc;ng&nbsp;<br />\n" +
                "            The University of Florida&nbsp;<br />\n" +
                "            <br />\n" +
                "            + The + số thứ tự + danh từ&nbsp;<br />\n" +
                "            The third chapter.&nbsp;<br />\n" +
                "            <br />\n" +
                "            + Trước t&ecirc;n c&aacute;c cuộc chiến tranh khu vực với điều kiện t&ecirc;n khu vực đ&oacute; phải được t&iacute;nh từ ho&aacute;&nbsp;<br />\n" +
                "            The Korean War (=&gt; The Vietnamese economy)&nbsp;<br />\n" +
                "            <br />\n" +
                "            + Trước t&ecirc;n c&aacute;c nước c&oacute; hai từ trở l&ecirc;n (ngoại trừ<em>Great</em>&nbsp;<em>Britain</em>)&nbsp;<br />\n" +
                "            The United States, The Central African Republic&nbsp;<br />\n" +
                "            <br />\n" +
                "            + Trước t&ecirc;n c&aacute;c nước được coi l&agrave; một quần đảo hoặc một quần đảo&nbsp;<br />\n" +
                "            The Philipines, The Virgin Islands, The Hawaii&nbsp;<br />\n" +
                "            <br />\n" +
                "            + Trước t&ecirc;n c&aacute;c t&agrave;i liệu hoặc sự kiện lịch sử&nbsp;<br />\n" +
                "            The Constitution, The Magna Carta&nbsp;<br />\n" +
                "            <br />\n" +
                "            + Trước t&ecirc;n c&aacute;c nh&oacute;m d&acirc;n tộc thiểu số&nbsp;<br />\n" +
                "            the Indians&nbsp;<br />\n" +
                "            <br />\n" +
                "            <br />\n" +
                "            <br />\n" +
                "            <br />\n" +
                "            <br />\n" +
                "            <br />\n" +
                "            + Trước t&ecirc;n c&aacute;c m&ocirc;n học cụ thể&nbsp;<br />\n" +
                "            The Solid matter Physics&nbsp;<br />\n" +
                "            <br />\n" +
                "            <br />\n" +
                "            <br />\n" +
                "            <br />\n" +
                "            + Trước t&ecirc;n c&aacute;c nhạc cụ khi đề cập đến c&aacute;c nhạc cụ đ&oacute; n&oacute;i chung hoặc khi chơi c&aacute;c nhạc cụ đ&oacute;.&nbsp;<br />\n" +
                "            The violin is difficult to play&nbsp;<br />\n" +
                "            Who is that on the piano&nbsp;</p>\n" +
                "            </td>\n" +
                "            <td valign=\"top\" style=\"width: 319px;\">+ Trước t&ecirc;n một hồ&nbsp;<br />\n" +
                "            Lake Geneva&nbsp;<br />\n" +
                "            <br />\n" +
                "            <br />\n" +
                "            <br />\n" +
                "            + Trước t&ecirc;n một ngọn n&uacute;i&nbsp;<br />\n" +
                "            Mount Vesuvius&nbsp;<br />\n" +
                "            <br />\n" +
                "            + Trước t&ecirc;n c&aacute;c h&agrave;nh tinh hoặc c&aacute;c ch&ograve;m sao&nbsp;<br />\n" +
                "            Venus, Mars&nbsp;<br />\n" +
                "            <br />\n" +
                "            <br />\n" +
                "            + Trước t&ecirc;n c&aacute;c trường n&agrave;y nếu trước n&oacute; l&agrave; một t&ecirc;n ri&ecirc;ng&nbsp;<br />\n" +
                "            Stetson University&nbsp;<br />\n" +
                "            <br />\n" +
                "            + Trước c&aacute;c danh từ đi c&ugrave;ng với một số đếm&nbsp;<br />\n" +
                "            Chapter three, Word War One&nbsp;<br />\n" +
                "            <br />\n" +
                "            <br />\n" +
                "            <br />\n" +
                "            <br />\n" +
                "            <br />\n" +
                "            + Trước t&ecirc;n c&aacute;c nước chỉ c&oacute; một từ:&nbsp;<br />\n" +
                "            China, France, Venezuela, Vietnam<br />\n" +
                "            <br />\n" +
                "            <br />\n" +
                "            + Trước t&ecirc;n c&aacute;c nước mở đầu bằng New, một t&iacute;nh từ chỉ hướng:&nbsp;<br />\n" +
                "            New Zealand, North Korean, France&nbsp;<br />\n" +
                "            <br />\n" +
                "            + Trước t&ecirc;n c&aacute;c lục địa, tỉnh, tiểu bang, th&agrave;nh phố, quận, huyện:<br />\n" +
                "            Europe, Florida&nbsp;<br />\n" +
                "            <br />\n" +
                "            + Trước t&ecirc;n bất k&igrave; m&ocirc;n thể thao n&agrave;o&nbsp;<br />\n" +
                "            baseball, basketball&nbsp;<br />\n" +
                "            <br />\n" +
                "            + Trước c&aacute;c danh từ trừu tượng (trừ một số trường hợp đặc biệt):<br />\n" +
                "            freedom, happiness&nbsp;<br />\n" +
                "            <br />\n" +
                "            + Trước t&ecirc;n c&aacute;c m&ocirc;n học n&oacute;i chung&nbsp;<br />\n" +
                "            mathematics&nbsp;<br />\n" +
                "            <br />\n" +
                "            + Trước t&ecirc;n c&aacute;c ng&agrave;y lễ, tết&nbsp;<br />\n" +
                "            Christmas, Thanksgiving&nbsp;<br />\n" +
                "            <br />\n" +
                "            + Trước t&ecirc;n c&aacute;c loại h&igrave;nh nhạc cụ trong c&aacute;c h&igrave;nh thức &acirc;m nhạc cụ thể (Jazz, Rock, classical music..)&nbsp;<br />\n" +
                "            To perform jazz on trumpet and piano&nbsp;</td>\n" +
                "        </tr>\n" +
                "    </tbody>\n" +
                "</table>\n" +
                "<h3><span style=\"color: #0070c0;\"><a name=\"2.4\">2.4</a>&nbsp;C&aacute;ch sử dụng another v&agrave; other.</span></h3>\n" +
                "<p>Hai từ n&agrave;y thường g&acirc;y nhầm lẫn.&nbsp;</p>\n" +
                "<table border=\"1\" width=\"100%\">\n" +
                "    <tbody>\n" +
                "        <tr>\n" +
                "            <td align=\"center\" style=\"width: 391px;\"><strong>D&ugrave;ng với danh từ đếm được</strong></td>\n" +
                "            <td align=\"center\" style=\"width: 247px;\"><strong>D&ugrave;ng với danh từ kh&ocirc;ng đếm được</strong></td>\n" +
                "        </tr>\n" +
                "        <tr>\n" +
                "            <td style=\"width: 391px;\">\n" +
                "            <ul>\n" +
                "                <li>an + other +&nbsp;<em>danh từ đếm được số &iacute;t</em>&nbsp;= một c&aacute;i nữa, một c&aacute;i kh&aacute;c, một người nữa, một người kh&aacute;c (= one more).<br />\n" +
                "                another pencil = one more pencil</li>\n" +
                "                <li>the other +&nbsp;<em>danh từ đếm được số &iacute;t</em>&nbsp;= c&aacute;i cuối c&ugrave;ng c&ograve;n lại (của một bộ), người c&ograve;n lại (của một nh&oacute;m), = last of the set.<br />\n" +
                "                the other pencil = the last pencil present</li>\n" +
                "            </ul>\n" +
                "            </td>\n" +
                "            <td style=\"width: 247px;\">\n" +
                "            <p style=\"text-align: center;\">Kh&ocirc;ng d&ugrave;ng</p>\n" +
                "            </td>\n" +
                "        </tr>\n" +
                "        <tr>\n" +
                "            <td style=\"width: 391px;\">\n" +
                "            <ul>\n" +
                "                <li>Other +&nbsp;<em>danh từ đếm được số nhiều</em>&nbsp;= mấy c&aacute;i nữa, mấy c&aacute;i kh&aacute;c, mấy người nữa, mấy người kh&aacute;c (= more of the set).<br />\n" +
                "                other pencils = some more pencils</li>\n" +
                "                <li>The other +&nbsp;<em>danh từ đếm được số nhiều</em>&nbsp;= những c&aacute;i c&ograve;n lại (của một bộ), những người c&ograve;n lại (của một nh&oacute;m), = the rest of the set.<br />\n" +
                "                the other pencils = all remaining pencils</li>\n" +
                "            </ul>\n" +
                "            </td>\n" +
                "            <td style=\"width: 247px;\">\n" +
                "            <ul>\n" +
                "                <li>Other +&nbsp;<em>danh từ kh&ocirc;ng đếm được</em>&nbsp;= một ch&uacute;t nữa (= more of the set).<br />\n" +
                "                other water = some more water</li>\n" +
                "                <li>The other +&nbsp;<em>danh từ kh&ocirc;ng đếm được</em>&nbsp;= chỗ c&ograve;n s&oacute;t lại.<br />\n" +
                "                the other water = the remaining water</li>\n" +
                "            </ul>\n" +
                "            </td>\n" +
                "        </tr>\n" +
                "    </tbody>\n" +
                "</table>\n" +
                "<p>&middot;&nbsp;<em>Another</em>&nbsp;v&agrave;&nbsp;<em>other</em>&nbsp;l&agrave; kh&ocirc;ng x&aacute;c định trong khi&nbsp;<em>the other</em>&nbsp;l&agrave; x&aacute;c định; nếu chủ ngữ l&agrave; đ&atilde; biết (được nhắc đến trước đ&oacute;) th&igrave; ta c&oacute; thể bỏ danh từ đi sau&nbsp;<em>another</em>&nbsp;hoặc&nbsp;<em>other</em>, chỉ cần d&ugrave;ng&nbsp;<em>another</em>&nbsp;hoặc&nbsp;<em>other</em>&nbsp;như một đại từ l&agrave; đủ.&nbsp;Khi danh từ số nhiều bị lược bớt (trong c&aacute;ch n&oacute;i tắt n&ecirc;u tr&ecirc;n) th&igrave;&nbsp;<em>other</em>&nbsp;trở th&agrave;nh&nbsp;<em>others</em>. Kh&ocirc;ng bao giờ được d&ugrave;ng&nbsp;<em>others</em>&nbsp;+ danh từ số nhiều:</p>\n" +
                "<blockquote>\n" +
                "<p>I Don 't want this book. Please give me&nbsp;<span style=\"text-decoration: underline;\">another</span>.<br />\n" +
                "(another = any other book - not specific)&nbsp;<br />\n" +
                "<br />\n" +
                "I Don 't want this book. Please give me&nbsp;<span style=\"text-decoration: underline;\">the other</span>.&nbsp;<br />\n" +
                "(the other = the other book, specific)&nbsp;<br />\n" +
                "<br />\n" +
                "This chemical is poisonous.&nbsp;<span style=\"text-decoration: underline;\">Others</span>&nbsp;are poisonous too.<br />\n" +
                "(others = the other chemicals, not specific)&nbsp;<br />\n" +
                "<br />\n" +
                "I Don 't want these books. Please give me&nbsp;<span style=\"text-decoration: underline;\">the others</span>.&nbsp;<br />\n" +
                "(the others = the other books, specific)&nbsp;</p>\n" +
                "</blockquote>\n" +
                "<p>&middot; Trong một số trường hợp người ta d&ugrave;ng&nbsp;<em>one</em>&nbsp;hoặc&nbsp;<em>ones</em>&nbsp;đằng sau another hoặc other thay cho danh từ:</p>\n" +
                "<blockquote>\n" +
                "<p>I Don 't want this book. Please give me&nbsp;<span style=\"text-decoration: underline;\">another one</span>.<br />\n" +
                "I don't want this book. Please give me the&nbsp;<span style=\"text-decoration: underline;\">other one</span>.&nbsp;<br />\n" +
                "This chemical is poisonous.&nbsp;<span style=\"text-decoration: underline;\">Other ones</span>&nbsp;are poisonous too.<br />\n" +
                "I don't want these books. Please give me the&nbsp;<span style=\"text-decoration: underline;\">other ones</span>.&nbsp;</p>\n" +
                "</blockquote>\n" +
                "<p>&middot;&nbsp;<em>This</em>&nbsp;hoặc&nbsp;<em>that</em>&nbsp;c&oacute; thể d&ugrave;ng với&nbsp;<em>one</em>&nbsp;nhưng&nbsp;<em>these</em>&nbsp;v&agrave;&nbsp;<em>those</em>&nbsp;kh&ocirc;ng được d&ugrave;ng với&nbsp;<em>ones</em>, mặc d&ugrave; cả 4 từ n&agrave;y đều c&oacute; thể d&ugrave;ng thay cho danh từ (với vai tr&ograve; l&agrave; đại từ) khi kh&ocirc;ng đi với&nbsp;<em>one</em>&nbsp;hoặc&nbsp;<em>ones</em>:&nbsp;</p>\n" +
                "<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; I don't want this book. I want&nbsp;<span style=\"text-decoration: underline;\">that</span>.&nbsp;</p>\n" +
                "<h3><span style=\"color: #0070c0;\"><a name=\"2.5\">2.5</a>&nbsp;C&aacute;ch sử dụng little, a little, few, a few</span></h3>\n" +
                "<p>&middot; Little +&nbsp;<em>danh từ kh&ocirc;ng đếm được</em>: rất &iacute;t, kh&ocirc;ng đủ để (c&oacute; khuynh hướng phủ định)<br />\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; I have&nbsp;<span style=\"text-decoration: underline;\">little money</span>,&nbsp;<span style=\"text-decoration: underline;\">not enough</span>&nbsp;to buy groceries.<br />\n" +
                "<br />\n" +
                "&middot; A little +&nbsp;<em>danh từ kh&ocirc;ng đếm được</em>: c&oacute; một ch&uacute;t, đủ để<br />\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; I have&nbsp;<span style=\"text-decoration: underline;\">a little money</span>,&nbsp;<span style=\"text-decoration: underline;\">enough</span>&nbsp;to buy groceries<br />\n" +
                "<br />\n" +
                "&middot; Few +&nbsp;<em>danh từ đếm được số nhiều</em>: c&oacute; rất &iacute;t, kh&ocirc;ng đủ để (c&oacute; t&iacute;nh phủ định)<br />\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; I have&nbsp;<span style=\"text-decoration: underline;\">few books</span>,&nbsp;<span style=\"text-decoration: underline;\">not enough</span>&nbsp;for reference reading<br />\n" +
                "<br />\n" +
                "&middot; A few + danh từ đếm được số nhiều: c&oacute; một ch&uacute;t, đủ để<br />\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; I have&nbsp;<span style=\"text-decoration: underline;\">a few records</span>,&nbsp;<span style=\"text-decoration: underline;\">enough</span>&nbsp;for listening.<br />\n" +
                "<br />\n" +
                "&middot; Trong một số trường hợp khi danh từ ở tr&ecirc;n đ&atilde; được nhắc đến th&igrave; ở ph&iacute;a dưới chỉ cần d&ugrave;ng little hoặc few như một đại từ l&agrave; đủ (cũng giống như đối với other/another; this/that).<br />\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Are you ready in money. Yes,&nbsp;<span style=\"text-decoration: underline;\">a little</span>.<br />\n" +
                "<br />\n" +
                "&middot; Quite a few +&nbsp;<em>đếm được</em>&nbsp;= Quite a bit +&nbsp;<em>kh&ocirc;ng đếm được</em>&nbsp;= Quite a lot of +&nbsp;<em>noun</em>&nbsp;= rất nhiều.</p>\n" +
                "<h3><span style=\"color: #0070c0;\"><a name=\"2.6\">2.6</a>&nbsp;Sở hữu c&aacute;ch</span></h3>\n" +
                "<p>&middot; The noun's + noun: Chỉ được d&ugrave;ng cho những danh từ chỉ người hoặc động vật, kh&ocirc;ng d&ugrave;ng cho c&aacute;c đồ vật.<br />\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; The&nbsp;<span style=\"text-decoration: underline;\">student's</span>&nbsp;book,&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; The&nbsp;<span style=\"text-decoration: underline;\">cat's</span>&nbsp;legs.<br />\n" +
                "<br />\n" +
                "&middot; Đối với danh từ số nhiều đ&atilde; c&oacute; sẵn \"s\" ở đu&ocirc;i chỉ cần d&ugrave;ng dấu phẩy<br />\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; The&nbsp;<span style=\"text-decoration: underline;\">students'</span>&nbsp;book.<br />\n" +
                "<br />\n" +
                "&middot; Nhưng đối với những danh từ đổi số nhiều đặc biệt kh&ocirc;ng \"s\" ở đu&ocirc;i vẫn phải d&ugrave;ng đầy đủ dấu sở hữu c&aacute;ch.<br />\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; The c<span style=\"text-decoration: underline;\">hildren's</span>&nbsp;toys,&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; The&nbsp;<span style=\"text-decoration: underline;\">people's</span>&nbsp;willing<br />\n" +
                "<br />\n" +
                "&middot; Nếu c&oacute; hai danh từ c&ugrave;ng đứng ở sở hữu c&aacute;ch th&igrave; danh từ n&agrave;o đứng gần danh từ bị sở hữu nhất sẽ mang dấu sở hữu.<br />\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span style=\"text-decoration: underline;\">Paul and Peter's</span>&nbsp;room.<br />\n" +
                "<br />\n" +
                "&middot; Đối với những t&ecirc;n ri&ecirc;ng hoặc danh từ đ&atilde; c&oacute; sẵn \"s\" ở đu&ocirc;i c&oacute; thể chỉ cần d&ugrave;ng dấu phẩy v&agrave; nhấn mạnh đu&ocirc;i khi đọc hoặc d&ugrave;ng sở hữu c&aacute;ch v&agrave; phải thay đổi c&aacute;ch đọc. T&ecirc;n ri&ecirc;ng kh&ocirc;ng d&ugrave;ng \"the\" đằng trước.<br />\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; The&nbsp;<span style=\"text-decoration: underline;\">boss'</span>&nbsp;car = the&nbsp;<strong><span style=\"text-decoration: underline;\">boss 's</span></strong>&nbsp;car [bosiz]<br />\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span style=\"text-decoration: underline;\">Agnes'</span>&nbsp;house =&nbsp;<strong><span style=\"text-decoration: underline;\">Agnes 's</span></strong>&nbsp;[siz] house.<br />\n" +
                "<br />\n" +
                "&middot; Sở hữu c&aacute;ch cũng được d&ugrave;ng cho thời gian (năm, th&aacute;ng, thập ni&ecirc;n, thế kỉ)<br />\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span style=\"text-decoration: underline;\">The 1990s'</span>&nbsp;events: những sự kiện của thập ni&ecirc;n 90<br />\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span style=\"text-decoration: underline;\">The 21st century's</span>&nbsp;prospects.<br />\n" +
                "<br />\n" +
                "&middot; D&ugrave;ng cho c&aacute;c m&ugrave;a trong năm trừ m&ugrave;a xu&acirc;n v&agrave; m&ugrave;a thu. Nếu d&ugrave;ng sở hữu c&aacute;ch cho hai m&ugrave;a n&agrave;y th&igrave; người viết đ&atilde; nh&acirc;n c&aacute;ch ho&aacute; ch&uacute;ng. Ng&agrave;y nay người ta d&ugrave;ng c&aacute;c m&ugrave;a trong năm như một t&iacute;nh từ cho c&aacute;c danh từ đằng sau, &iacute;t d&ugrave;ng sở hữu c&aacute;ch.<br />\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span style=\"text-decoration: underline;\">The Autumn's leaf</span>: chiếc l&aacute; của n&agrave;ng thu.<br />\n" +
                "<br />\n" +
                "&middot; D&ugrave;ng cho t&ecirc;n c&aacute;c c&ocirc;ng ty lớn, c&aacute;c quốc gia<br />\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span style=\"text-decoration: underline;\">The Rockerfeller's</span>&nbsp;oil products.&nbsp;<br />\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span style=\"text-decoration: underline;\">China's</span>&nbsp;food.<br />\n" +
                "<br />\n" +
                "&middot; Đối với c&aacute;c cửa hiệu c&oacute; nghề nghiệp đặc trưng chỉ cần d&ugrave;ng danh từ với dấu sở hữu.<br />\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; In a&nbsp;<span style=\"text-decoration: underline;\">florist's</span><br />\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; At a&nbsp;<span style=\"text-decoration: underline;\">hairdresser's</span><br />\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Đặc biệt l&agrave; c&aacute;c tiệm ăn với t&ecirc;n ri&ecirc;ng: The&nbsp;<span style=\"text-decoration: underline;\">Antonio's</span><br />\n" +
                "<br />\n" +
                "&middot; D&ugrave;ng trước một số danh từ bất động vật chỉ trong một số th&agrave;nh ngữ<br />\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; a&nbsp;<span style=\"text-decoration: underline;\">stone's</span>&nbsp;throw from ...(C&aacute;ch nơi đ&acirc;u một tầm đ&aacute; n&eacute;m).<br />\n" +
                "<br />\n" +
                "<br />\n" +
                "</p>\n" +
                "\t</body>\n" +
                "</html>"));
        grammars.add(new Grammar("Verb phrase (ngữ động từ)", "<!DOCTYPE html>\n" +
                "<html>\n" +
                "\t<head>\n" +
                "\t\t<meta charset=\"UTF-8\">\n" +
                "\t\t<title>Ngữ Pháp Tiếng Anh</title>\n" +
                "\t\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\"> \t\t\n" +
                "\t</head>\n" +
                "\t<body style=\"font-size:13px; text-align:justify\">\n" +
                "<h3><span style=\"color: #4f81bd;\"><a name=\"3\">3</a>. Verb phrase (ngữ động từ)</span></h3>\n" +
                "<p>Như đ&atilde; đề cập ở phần cấu tr&uacute;c chung của c&acirc;u, ngữ động từ tiếng Anh gồm c&oacute; một động từ ch&iacute;nh v&agrave; một hoặc nhi&ecirc;u trợ động từ. Động từ trong tiếng Anh chia l&agrave;m 3 thời ch&iacute;nh:<br />\n" +
                "<br />\n" +
                "Qu&aacute; khứ (Past)<br />\n" +
                "Hiện tại (Present)<br />\n" +
                "Tương lai (Future)<br />\n" +
                "<br />\n" +
                "Mỗi thời ch&iacute;nh lại chia th&agrave;nh nhiều thời nhỏ để diễn đạt t&iacute;nh ch&iacute;nh x&aacute;c của h&agrave;nh động.</p>\n" +
                "<h3><span style=\"color: #0070c0;\"><a name=\"3.1\">3.1</a>&nbsp;Present tenses (c&aacute;c thời hiện tại)</span></h3>\n" +
                "<h4><span style=\"color: #0070c0;\"><a name=\"3.1.1\">3.1.1</a>&nbsp;Simple Present (thời hiện tại thường)</span></h4>\n" +
                "<p>D&ugrave;ng để diễn đạt một h&agrave;nh động mang t&iacute;nh thường xuy&ecirc;n (regular action), theo th&oacute;i quen (habitual action) hoặc h&agrave;nh động lặp đi lặp lại c&oacute; t&iacute;nh qui luật.<br />\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; I&nbsp;<span style=\"text-decoration: underline;\">walk</span>&nbsp;to school every day.&nbsp;<br />\n" +
                "Khi chia động từ ở thời n&agrave;y, đối với ng&ocirc;i thứ nhất (I), thứ hai (you) v&agrave; thứ 3 số nhiều (they) động từ kh&ocirc;ng phải chia, sử dụng động từ nguy&ecirc;n thể kh&ocirc;ng c&oacute;&nbsp;<em>to</em>&nbsp;như ở v&iacute; dụ n&ecirc;u tr&ecirc;n. Đối với ng&ocirc;i thứ&nbsp; 3 số &iacute;t (he, she, it), phải c&oacute; \"s\" ở sau động từ v&agrave; &acirc;m đ&oacute; phải được đọc l&ecirc;n:&nbsp;<br />\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; He&nbsp;<span style=\"text-decoration: underline;\">walks</span>.&nbsp;<br />\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; She&nbsp;<span style=\"text-decoration: underline;\">watches</span>&nbsp;TV&nbsp;<br />\n" +
                "&nbsp;<br />\n" +
                "Thường d&ugrave;ng thời hiện tại thường với một số c&aacute;c ph&oacute; từ chỉ thời gian như today, present day, nowadays,... v&agrave; với c&aacute;c ph&oacute; từ chỉ tần suất như: always, sometimes, often, every + thời gian ...&nbsp;<br />\n" +
                "<br />\n" +
                "Simple present thường kh&ocirc;ng d&ugrave;ng để diễn đạt h&agrave;nh động đang xảy ra ở thời điểm hiện tại (now), ngoại trừ với c&aacute;c động từ thể hiện trạng th&aacute;i (stative verb) như sau:</p>\n" +
                "<table border=\"0\" width=\"100%\">\n" +
                "    <tbody>\n" +
                "        <tr>\n" +
                "            <td style=\"width: 210px;\">know<br />\n" +
                "            believe<br />\n" +
                "            hear<br />\n" +
                "            see<br />\n" +
                "            smell<br />\n" +
                "            wish</td>\n" +
                "            <td style=\"width: 210px;\">understand<br />\n" +
                "            hate<br />\n" +
                "            love<br />\n" +
                "            like<br />\n" +
                "            want<br />\n" +
                "            sound</td>\n" +
                "            <td style=\"width: 216px;\">have<br />\n" +
                "            need<br />\n" +
                "            appear<br />\n" +
                "            seem<br />\n" +
                "            taste<br />\n" +
                "            own&nbsp;</td>\n" +
                "        </tr>\n" +
                "    </tbody>\n" +
                "</table>\n" +
                "<p>C&aacute;c từ trong danh s&aacute;ch tr&ecirc;n thường cũng kh&ocirc;ng bao giờ xuất hiện trong thời tiếp diễn (hiện tại tiếp diễn, qu&aacute; khứ tiếp diễn...).<br />\n" +
                "<br />\n" +
                "<strong><span style=\"color: #0070c0;\">Một số v&iacute; dụ kh&aacute;c về thời hiện tại thường:</span></strong></p>\n" +
                "<blockquote>\n" +
                "<p>They&nbsp;<span style=\"text-decoration: underline;\">understand</span>&nbsp;the problem now. (stative verb)<br />\n" +
                "He always&nbsp;<span style=\"text-decoration: underline;\">swims</span>&nbsp;in the evening. (habitual action)<br />\n" +
                "We&nbsp;<span style=\"text-decoration: underline;\">want</span>&nbsp;to leave now. (stative verb)<br />\n" +
                "The coffee&nbsp;<span style=\"text-decoration: underline;\">tastes</span>&nbsp;delicious. (stative verb)<br />\n" +
                "Your cough&nbsp;<span style=\"text-decoration: underline;\">sounds</span>&nbsp;bad. (stative verb)<br />\n" +
                "I&nbsp;<span style=\"text-decoration: underline;\">walk</span>&nbsp;to school every day. (habitual action)</p>\n" +
                "</blockquote>\n" +
                "<h4><span style=\"color: #0070c0;\"><a name=\"3.1.2\">3.1.2</a>&nbsp;Present Progressive (thời hiện tại tiếp diễn)</span></h4>\n" +
                "<p style=\"text-align: center;\"><strong><span style=\"color: #c00000;\">Subject + am/is/are + [verb-ing]</span></strong></p>\n" +
                "<p>&middot; D&ugrave;ng để diễn đạt một h&agrave;nh động xảy ra v&agrave;o thời điểm hiện tại. Thời điểm n&agrave;y được x&aacute;c định cụ thể bằng một số ph&oacute; từ như : now, rightnow, at this moment.&nbsp;&nbsp;<br />\n" +
                "&middot; D&ugrave;ng thay thế cho thời tương lai gần, đặc biệt l&agrave; trong văn n&oacute;i.<br />\n" +
                "<br />\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; The president&nbsp;<span style=\"text-decoration: underline;\">is trying</span>&nbsp;to contact his advisors&nbsp;<span style=\"text-decoration: underline;\">now</span>. (present time)<br />\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; We&nbsp;<span style=\"text-decoration: underline;\">are flying</span>&nbsp;to Paris&nbsp;<span style=\"text-decoration: underline;\">next month</span>. (future time)&nbsp;<br />\n" +
                "<br />\n" +
                "&middot; C&aacute;c động từ trạng th&aacute;i (stative verb) ở bảng sau kh&ocirc;ng được chia ở thể tiếp diễn (bất cứ thời n&agrave;o) khi ch&uacute;ng l&agrave; những động từ tĩnh diễn đạt trạng th&aacute;i cảm gi&aacute;c của hoạt động tinh thần hoặc t&iacute;nh chất của sự vật, sự việc.</p>\n" +
                "<table border=\"0\" width=\"100%\">\n" +
                "    <tbody>\n" +
                "        <tr>\n" +
                "            <td style=\"width: 210px;\">know<br />\n" +
                "            believe<br />\n" +
                "            hear<br />\n" +
                "            see<br />\n" +
                "            smell<br />\n" +
                "            wish</td>\n" +
                "            <td style=\"width: 210px;\">understand<br />\n" +
                "            hate<br />\n" +
                "            love<br />\n" +
                "            like<br />\n" +
                "            want<br />\n" +
                "            sound</td>\n" +
                "            <td style=\"width: 216px;\">have<br />\n" +
                "            need<br />\n" +
                "            appear<br />\n" +
                "            seem<br />\n" +
                "            taste<br />\n" +
                "            own</td>\n" +
                "        </tr>\n" +
                "    </tbody>\n" +
                "</table>\n" +
                "<p>Nhưng khi ch&uacute;ng quay sang hướng động từ h&agrave;nh động th&igrave; ch&uacute;ng lại được ph&eacute;p d&ugrave;ng ở thể tiếp diễn.&nbsp;<br />\n" +
                "<br />\n" +
                "He&nbsp;<span style=\"text-decoration: underline;\">has</span>&nbsp;a lot of books.<br />\n" +
                "He&nbsp;<span style=\"text-decoration: underline;\">is having</span>&nbsp;dinner now. (Động từ h&agrave;nh động: ăn tối)<br />\n" +
                "I&nbsp;<span style=\"text-decoration: underline;\">think</span>&nbsp;they will come in time.<br />\n" +
                "I'<span style=\"text-decoration: underline;\">m thinking</span>&nbsp;of my test tomorrow. (Động từ h&agrave;nh động: Đang nghĩ về)&nbsp;</p>\n" +
                "<h4><span style=\"color: #0070c0;\"><a name=\"3.1.3\">3.1.3</a>&nbsp;Present Perfect (thời hiện tại ho&agrave;n th&agrave;nh)</span></h4>\n" +
                "<p style=\"text-align: center;\"><strong><span style=\"color: #c00000;\">Subject + have/has + [verb in past participle] + ...</span></strong></p>\n" +
                "<p>Thời hiện tại ho&agrave;n th&agrave;nh d&ugrave;ng để:<br />\n" +
                "(1). Diễn đạt một h&agrave;nh động xảy ra ở một thời điểm kh&ocirc;ng x&aacute;c định trong qu&aacute; khứ.<br />\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; John&nbsp;<span style=\"text-decoration: underline;\">has traveled</span>&nbsp;around the world. (We don't know when)&nbsp;<br />\n" +
                "(2). Chỉ một h&agrave;nh động xảy ra nhiều lần trong qu&aacute; khứ.<br />\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; George&nbsp;<span style=\"text-decoration: underline;\">has seen</span>&nbsp;this movie three time.&nbsp;&nbsp;<br />\n" +
                "(3). Một h&agrave;nh động bắt đầu diễn ra trong qu&aacute; khứ v&agrave; vẫn c&ograve;n xảy ra ở hiện tại.<br />\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; John&nbsp;<span style=\"text-decoration: underline;\">has lived</span>&nbsp;in that house for 20 years. (He still lives there.)<br />\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp; = John&nbsp;<span style=\"text-decoration: underline;\">has lived</span>&nbsp;in that house since 1984. (Giả sử hiện nay l&agrave; 2004)</p>\n" +
                "<h5><span style=\"color: #0070c0;\"><a name=\"3.1.3.1\">3.1.3.1</a>&nbsp;C&aacute;ch d&ugrave;ng SINCE v&agrave; FOR:</span></h5>\n" +
                "<p>FOR + khoảng thời gian: for three days, for ten minutes, for twenty years ...<br />\n" +
                "SINCE + thời điểm bắt đầu: since 1982, since January, ...&nbsp;</p>\n" +
                "<h5><span style=\"color: #0070c0;\"><a name=\"3.1.3.2\">3.1.3.2</a>&nbsp;C&aacute;ch d&ugrave;ng ALREADY v&agrave; YET</span>:</h5>\n" +
                "<p>Already d&ugrave;ng trong c&acirc;u khẳng định, already c&oacute; thể đứng ngay sau&nbsp;<em>have</em>&nbsp;v&agrave; cũng c&oacute; thể đứng ở cuối c&acirc;u.&nbsp;</p>\n" +
                "<p style=\"text-align: center;\"><strong><span style=\"color: #c00000;\">Subject + have/has + already + [verb in past participle] + ...</span></strong></p>\n" +
                "<blockquote>\n" +
                "<p>We&nbsp;<span style=\"text-decoration: underline;\">have already written</span>&nbsp;our reports.&nbsp;<br />\n" +
                "We&nbsp;<span style=\"text-decoration: underline;\">have written</span>&nbsp;our reports&nbsp;<span style=\"text-decoration: underline;\">already</span>.&nbsp;</p>\n" +
                "</blockquote>\n" +
                "<p>Yet d&ugrave;ng trong c&acirc;u phủ định, c&acirc;u nghi vấn. Yet thường xuy&ecirc;n đứng ở cuối c&acirc;u.</p>\n" +
                "<p style=\"text-align: center;\"><span style=\"color: #c00000;\"><strong>Subject + have/has + not + [verb in past participle] + ... + yet.</strong></span></p>\n" +
                "<blockquote>\n" +
                "<p>We&nbsp;<span style=\"text-decoration: underline;\">have'nt written</span>&nbsp;our reports&nbsp;<span style=\"text-decoration: underline;\">yet</span>.<br />\n" +
                "<span style=\"text-decoration: underline;\">Have</span>&nbsp;you&nbsp;<span style=\"text-decoration: underline;\">written</span>&nbsp;your reports&nbsp;<span style=\"text-decoration: underline;\">yet</span>?&nbsp;</p>\n" +
                "</blockquote>\n" +
                "<p>Trong một số trường hợp ở thể phủ định, yet c&oacute; thể đứng ngay sau have nhưng phải thay đổi về mặt ngữ ph&aacute;p: động từ PII trở về dạng nguy&ecirc;n thể c&oacute;&nbsp;<em>to</em>&nbsp;v&agrave; kh&ocirc;ng d&ugrave;ng&nbsp;<em>not</em>.</p>\n" +
                "<p style=\"text-align: center;\"><span style=\"color: #c00000;\"><strong>Subject + have/has + yet + [verb in infinitive] + ...</strong></span></p>\n" +
                "<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; John&nbsp;<span style=\"text-decoration: underline;\">has</span>&nbsp;<span style=\"text-decoration: underline;\">yet</span>&nbsp;<span style=\"text-decoration: underline;\">to</span>&nbsp;<span style=\"text-decoration: underline;\">learn</span>&nbsp;the material = John&nbsp;<span style=\"text-decoration: underline;\">hasn't learnt</span>&nbsp;the material&nbsp;<span style=\"text-decoration: underline;\">yet</span>.</p>\n" +
                "<h5><span style=\"color: #0070c0;\"><a name=\"3.1.3.3\">3.1.3.3</a>&nbsp;Thời hiện tại ho&agrave;n th&agrave;nh thường dược d&ugrave;ng với một số cụm từ chỉ thời gian như sau:</span></h5>\n" +
                "<p>&middot; D&ugrave;ng với now that... (giờ đ&acirc;y khi m&agrave;...)&nbsp;<br />\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span style=\"text-decoration: underline;\">Now that</span>&nbsp;you&nbsp;<span style=\"text-decoration: underline;\">have passed</span>&nbsp;the TOEFL test successfully, you can apply for the schoolarship.<br />\n" +
                "&middot; D&ugrave;ng với một số ph&oacute; từ như till now, untill now, so far (cho đến giờ). Những cụm từ n&agrave;y c&oacute; thể đứng đầu c&acirc;u hoặc cuối c&acirc;u.<br />\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span style=\"text-decoration: underline;\">So far</span>&nbsp;the problem has not been resolved.&nbsp;<br />\n" +
                "&middot; D&ugrave;ng với recently, lately (gần đ&acirc;y) những cụm từ n&agrave;y c&oacute; thể đứng đầu hoặc cuối c&acirc;u.&nbsp;<br />\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; I have not seen him&nbsp;<span style=\"text-decoration: underline;\">recently</span>.&nbsp;<br />\n" +
                "&middot; D&ugrave;ng với before đứng ở cuối c&acirc;u.&nbsp;<br />\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; I have seen him&nbsp;<span style=\"text-decoration: underline;\">before</span>.&nbsp;<em><br />\n" +
                "</em></p>\n" +
                "<h4><span style=\"color: #0070c0;\"><a name=\"3.1.4\">3.1.4</a>&nbsp;Present Perfect Progressive (thời hiện tại ho&agrave;n th&agrave;nh tiếp diễn)</span></h4>\n" +
                "<p style=\"text-align: center;\"><span style=\"color: #c00000;\"><strong>Subject + have/has + been + [verb-ing] + ...</strong></span></p>\n" +
                "<p>Chỉ đối với c&aacute;c h&agrave;nh động thộc loại (3) của thời hiện tại ho&agrave;n th&agrave;nh ch&uacute;ng ta mới c&oacute; thể d&ugrave;ng thời hiện tại ho&agrave;n th&agrave;nh tiếp diễn.&nbsp;<br />\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; John&nbsp;<span style=\"text-decoration: underline;\">has been living</span>&nbsp;in that house for 20 years.&nbsp;<br />\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp; = John&nbsp;<span style=\"text-decoration: underline;\">has lived</span>&nbsp;in that house for 20 years.</p>\n" +
                "<p><strong><span style=\"color: #0070c0;\">Ph&acirc;n biệt c&aacute;ch d&ugrave;ng giữa hai thời:&nbsp;</span></strong></p>\n" +
                "<table border=\"1\" width=\"100%\">\n" +
                "    <tbody>\n" +
                "        <tr>\n" +
                "            <td style=\"width: 319px;\"><strong>Present Perfect&nbsp;</strong></td>\n" +
                "            <td style=\"width: 319px;\"><strong>Present Perfect Progressive&nbsp;</strong></td>\n" +
                "        </tr>\n" +
                "        <tr>\n" +
                "            <td style=\"width: 319px;\">H&agrave;nh động đ&atilde; chấm dứt ở hiện tại do đ&oacute; đ&atilde; c&oacute; kết quả r&otilde; rệt.&nbsp;&nbsp;<br />\n" +
                "            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; I<span style=\"text-decoration: underline;\">'ve waited</span>&nbsp;for you for half an hour.&nbsp;<br />\n" +
                "            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; (and now I stop waiting because you didn't come).</td>\n" +
                "            <td style=\"width: 319px;\">H&agrave;nh động vẫn tiếp diễn ở hiện tại, c&oacute; khả năng lan tới tương lai do đ&oacute; kh&ocirc;ng c&oacute; kết quả r&otilde; rệt.&nbsp;<br />\n" +
                "            <br />\n" +
                "            &nbsp;&nbsp;&nbsp; I've been waiting for you for half an hour.&nbsp;<br />\n" +
                "            &nbsp;&nbsp;&nbsp; (and now I'm still waiting, hoping that you'll come)&nbsp;</td>\n" +
                "        </tr>\n" +
                "    </tbody>\n" +
                "</table>\n" +
                "<h3><span style=\"color: #0070c0;\"><a name=\"3.2\">3.2</a>&nbsp;Past tenses (c&aacute;c thời qu&aacute; khứ)</span></h3>\n" +
                "<h4><span style=\"color: #0070c0;\"><a name=\"3.2.1\">3.2.1</a>&nbsp;Simple Past (thời qu&aacute; khứ thường):</span></h4>\n" +
                "<p style=\"text-align: center;\"><strong><span style=\"color: #c00000;\">Subject + [verb in past tense (PI)] + ...</span></strong></p>\n" +
                "<p>D&ugrave;ng để diễn đạt một h&agrave;nh động đ&atilde; xảy ra dứt điểm tại một thời gian x&aacute;c định trong qu&aacute; khứ (kh&ocirc;ng c&ograve;n diễn ra hoặc ảnh hưởng tới hiện tại). Thời điểm trong c&acirc;u được x&aacute;c định r&otilde; rệt bằng một số c&aacute;c ph&oacute; từ chỉ thời gian như: yesterday, at that moment, last week, ...</p>\n" +
                "<blockquote>\n" +
                "<p>He&nbsp;<span style=\"text-decoration: underline;\">went</span>&nbsp;to Spain&nbsp;<span style=\"text-decoration: underline;\">last year</span>.<br />\n" +
                "Bob&nbsp;<span style=\"text-decoration: underline;\">bought</span>&nbsp;a new bicyle&nbsp;<span style=\"text-decoration: underline;\">yesterday</span>.<br />\n" +
                "Maria&nbsp;<span style=\"text-decoration: underline;\">did</span>&nbsp;her homework&nbsp;<span style=\"text-decoration: underline;\">last night</span>.<br />\n" +
                "Mark&nbsp;<span style=\"text-decoration: underline;\">washed</span>&nbsp;the dishes&nbsp;<span style=\"text-decoration: underline;\">after dinner</span>.<br />\n" +
                "We&nbsp;<span style=\"text-decoration: underline;\">drove</span>&nbsp;to the grocery store&nbsp;<span style=\"text-decoration: underline;\">this afternoon</span>.<br />\n" +
                "George&nbsp;<span style=\"text-decoration: underline;\">cooked</span>&nbsp;dinner for his family&nbsp;<span style=\"text-decoration: underline;\">Saturday night</span>.</p>\n" +
                "</blockquote>\n" +
                "<h4><span style=\"color: #0070c0;\"><a name=\"3.2.2\">3.2.2</a>&nbsp;Past Progresseive (thời qu&aacute; khứ tiếp diễn):</span></h4>\n" +
                "<p style=\"text-align: center;\"><span style=\"color: #c00000;\"><strong>Subject + was/were + [verb-ing] + ...</strong></span></p>\n" +
                "<p>Thời qu&aacute; khứ tiếp diễn d&ugrave;ng để diễn đạt:</p>\n" +
                "<p>(1) một h&agrave;nh động đang xảy ra trong qu&aacute; khứ th&igrave; bị một h&agrave;nh động kh&aacute;c &ldquo;chen ngang&rdquo; (khi đang... th&igrave; bỗng...). Trong trường hợp n&agrave;y, mẫu c&acirc;u chung l&agrave;:</p>\n" +
                "<p style=\"text-align: center;\"><strong><span style=\"color: #c00000;\">Subject (1) + Past Progressive + when + Subject (2) + Simple Past</span></strong></p>\n" +
                "<p style=\"text-align: center;\">I&nbsp;<span style=\"text-decoration: underline;\">was watching</span>&nbsp;TV&nbsp;<span style=\"text-decoration: underline;\">when</span>&nbsp;she&nbsp;<span style=\"text-decoration: underline;\">came</span>&nbsp;home.<br />\n" +
                "<strong>hoặc</strong></p>\n" +
                "<p style=\"text-align: center;\"><strong><span style=\"color: #c00000;\">When + Subject (1) + Simple Past, Subject (2) + Past Progressive</span></strong></p>\n" +
                "<p style=\"text-align: center;\"><span style=\"text-decoration: underline;\">When</span>&nbsp;she&nbsp;<span style=\"text-decoration: underline;\">came</span>&nbsp;home, I&nbsp;<span style=\"text-decoration: underline;\">was watching</span>&nbsp;television.</p>\n" +
                "<p>(2) Hai h&agrave;nh động c&ugrave;ng đồng thời xảy ra trong qu&aacute; khứ. Trong trường hợp n&agrave;y, mẫu c&acirc;u sau được &aacute;p dụng:</p>\n" +
                "<p style=\"text-align: center;\"><span style=\"color: #c00000;\"><strong>Subject (1) + Past Progressive + while + Subject (2) + &nbsp;Past Progressive</strong></span></p>\n" +
                "<p style=\"text-align: center;\">Martha&nbsp;<span style=\"text-decoration: underline;\">was watching</span>&nbsp;television&nbsp;<span style=\"text-decoration: underline;\">while</span>&nbsp;John&nbsp;<span style=\"text-decoration: underline;\">was reading</span>&nbsp;a book.<br />\n" +
                "<strong>hoặc</strong></p>\n" +
                "<p style=\"text-align: center;\"><span style=\"color: #c00000;\"><strong>While + Subject (1) + Past Progressive + Subject (2) + Past Progressive</strong></span></p>\n" +
                "<p style=\"text-align: center;\"><span style=\"text-decoration: underline;\">While</span>&nbsp;John&nbsp;<span style=\"text-decoration: underline;\">was reading</span>&nbsp;a book, Martha&nbsp;<span style=\"text-decoration: underline;\">was watching</span>&nbsp;television.</p>\n" +
                "<p>Cấu tr&uacute;c sau đ&acirc;y cũng đ&ocirc;i khi được d&ugrave;ng nhưng kh&ocirc;ng th&ocirc;ng dụng bằng hai mẫu tr&ecirc;n:</p>\n" +
                "<p style=\"text-align: center;\"><strong><span style=\"color: #c00000;\">While + Subject (1) + Past Progressive + Subject (2) + Simple Past</span></strong></p>\n" +
                "<p style=\"text-align: center;\"><span style=\"text-decoration: underline;\">While</span>&nbsp;John&nbsp;<span style=\"text-decoration: underline;\">was reading</span>&nbsp;a book, Martha&nbsp;<span style=\"text-decoration: underline;\">watched</span>&nbsp;television.</p>\n" +
                "<p>(3) Một h&agrave;nh động đang xảy ra tại một thời điểm x&aacute;c định trong qu&aacute; khứ:</p>\n" +
                "<blockquote>\n" +
                "<p>Martha&nbsp;<span style=\"text-decoration: underline;\">was watching</span>&nbsp;TV at seven o&rsquo;clock last night.<br />\n" +
                "What&nbsp;<span style=\"text-decoration: underline;\">were</span>&nbsp;you&nbsp;<span style=\"text-decoration: underline;\">doing</span>&nbsp;at one o&rsquo;clock this afternoon?<br />\n" +
                "Henry&nbsp;<span style=\"text-decoration: underline;\">was eating</span>&nbsp;a snack at midnight last night.</p>\n" +
                "</blockquote>\n" +
                "<h4><span style=\"color: #0070c0;\"><a name=\"3.2.3\">3.2.3</a>&nbsp;Past Perfect (thời qu&aacute; khứ ho&agrave;n th&agrave;nh):</span></h4>\n" +
                "<p style=\"text-align: center;\"><strong><span style=\"color: #c00000;\">Subject + had + [verb in participle] + ...</span></strong></p>\n" +
                "<p>Thời qu&aacute; khứ ho&agrave;n th&agrave;nh được d&ugrave;ng để diễn đạt:<br />\n" +
                "(1) một h&agrave;nh động xảy ra trước một h&agrave;nh động kh&aacute;c trong qu&aacute; khứ, trong c&acirc;u thường c&oacute; c&oacute; 2 h&agrave;nh động:</p>\n" +
                "<div style=\"text-align: center;\"><br />\n" +
                "<div style=\"text-align: left;\"><span class=\"Apple-tab-span\" style=\"white-space: pre;\">\t</span><em>John had gone</em>&nbsp;(h&agrave;nh động 1) to the store before<em>&nbsp;he went home</em>&nbsp;(h&agrave;nh động 2).</div>\n" +
                "<div style=\"text-align: left;\"><span class=\"Apple-tab-span\" style=\"white-space: pre;\">\t</span><em>Jack told us</em>&nbsp;(h&agrave;nh động 1) yesterday that he&nbsp;<em>had visited England in 1970</em>&nbsp;(h&agrave;nh động 2).</div>\n" +
                "</div>\n" +
                "<p>Thời qu&aacute; khứ ho&agrave;n th&agrave;nh thường được d&ugrave;ng với 3 ph&oacute; từ chỉ thời gian l&agrave;: after, before v&agrave; when.</p>\n" +
                "<div style=\"text-align: center;\"><span class=\"Apple-tab-span\" style=\"white-space: pre;\">\t<strong><span style=\"color: #c00000;\">S + simple past + after + S + past perfect</span></strong><br />\n" +
                "<em>John went home after he had gone to the store.</em><br />\n" +
                "</span><span class=\"Apple-tab-span\" style=\"white-space: pre;\"><strong><span style=\"color: #c00000;\">S + past perfect + before + S + simple past</span></strong></span><span class=\"Apple-tab-span\" style=\"white-space: pre;\"><br />\n" +
                "<em>John had gone to the store before he went home.</em><br />\n" +
                "</span><strong style=\"white-space: pre;\"><span style=\"color: #c00000;\">After + S + past perfect, + S + simple past</span></strong><span class=\"Apple-tab-span\" style=\"white-space: pre;\"><br />\n" +
                "<em>After John had gone to the store, he went home.</em><br />\n" +
                "</span><span class=\"Apple-tab-span\" style=\"white-space: pre;\"><strong><span style=\"color: #c00000;\">Before + S + simple past, + S + past perfect</span></strong></span><span class=\"Apple-tab-span\" style=\"white-space: pre;\"><br />\n" +
                "<em>BeforeJohn went home, he had gone to the store.</em></span></div>\n" +
                "<p>Ph&oacute; từ when c&oacute; thể được d&ugrave;ng thay cho after v&agrave; before trong cả 4 mẫu tr&ecirc;n m&agrave; kh&ocirc;ng l&agrave;m thay đổi &yacute; nghĩa của c&acirc;u. Ch&uacute;ng ta vẫn biết h&agrave;nh động n&agrave;o xảy ra trước do c&oacute; sử dụng qu&aacute; khứ ho&agrave;n th&agrave;nh.<br />\n" +
                "<br />\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; The police&nbsp;<span style=\"text-decoration: underline;\">came</span>&nbsp;<span style=\"text-decoration: underline;\">when</span>&nbsp;the robber&nbsp;<span style=\"text-decoration: underline;\">had gone</span>&nbsp;away.<br />\n" +
                "<br />\n" +
                "(2) Một trạng th&aacute;i đ&atilde; tồn tại một thời gian trong qu&aacute; khứ nhưng đ&atilde; chấm dứt trước hiện tại. Trường hợp n&agrave;y tương tự trường hợp (3) đối với hiện tại ho&agrave;n th&agrave;nh nhưng trong trường hợp n&agrave;y kh&ocirc;ng c&oacute; li&ecirc;n hệ g&igrave; với hiện tại.<br />\n" +
                "<br />\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; John&nbsp;<span style=\"text-decoration: underline;\">had lived</span>&nbsp;in New York&nbsp;<span style=\"text-decoration: underline;\">for ten years</span>&nbsp;<span style=\"text-decoration: underline;\">before</span>&nbsp;he moved to VN.</p>\n" +
                "<h4><span style=\"color: #0070c0;\"><a name=\"3.2.4\">3.2.4</a>&nbsp;Past Perfect Progressive (thời qu&aacute; khứ ho&agrave;n th&agrave;nh tiếp diễn):</span></h4>\n" +
                "<p style=\"text-align: center;\"><strong><span style=\"color: #c00000;\">S + had been + [verb-ing] + ...</span></strong></p>\n" +
                "<p>Chỉ đối với c&aacute;c h&agrave;nh động thuộc nh&oacute;m (2) của thời qu&aacute; khứ ho&agrave;n th&agrave;nh ta mới c&oacute; thể d&ugrave;ng thời qu&aacute; khứ ho&agrave;n th&agrave;nh tiếp diễn, với &yacute; nghĩa của c&acirc;u kh&ocirc;ng thay đổi.&nbsp;&nbsp;<br />\n" +
                "<br />\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; John&nbsp;<span style=\"text-decoration: underline;\">had been living</span>&nbsp;in New York&nbsp;<span style=\"text-decoration: underline;\">for ten years</span>&nbsp;<span style=\"text-decoration: underline;\">before</span>&nbsp;he&nbsp;<span style=\"text-decoration: underline;\">moved</span>&nbsp;to VN.<br />\n" +
                "<br />\n" +
                "Lưu &yacute;: Thời n&agrave;y ng&agrave;y nay &iacute;t d&ugrave;ng, người ta thay thế n&oacute; bằng Past Perfect v&agrave; chỉ d&ugrave;ng khi n&agrave;o cần điễn đạt t&iacute;nh ch&iacute;nh x&aacute;c của h&agrave;nh động.</p>\n" +
                "<h3><span style=\"color: #0070c0;\"><a name=\"3.3\">3.3</a>&nbsp;Future tenses (c&aacute;c thời tương lai)</span></h3>\n" +
                "<h4><span style=\"color: #0070c0;\"><a name=\"3.3.1\">3.3.1</a>&nbsp;Simple Future (thời tương lai thường):</span></h4>\n" +
                "<p style=\"text-align: center;\"><strong><span style=\"color: #c00000;\">S + will / shall + [verb in simple form] + ...</span></strong></p>\n" +
                "<p>Ng&agrave;y nay ngữ ph&aacute;p hiện đại, đặc biệt l&agrave; ngữ ph&aacute;p Mĩ chấp nhận việc d&ugrave;ng will cho tất cả c&aacute;c ng&ocirc;i, c&ograve;n shall chỉ d&ugrave;ng với c&aacute;c ng&ocirc;i&nbsp;<em>I, we</em>&nbsp;trong một số trường hợp như sau:<br />\n" +
                "<br />\n" +
                "&middot; Đưa ra đề nghị một c&aacute;ch lịch sự:<br />\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Shall I take you coat?<br />\n" +
                "&middot; D&ugrave;ng để mời người kh&aacute;c một c&aacute;ch lịch sự:<br />\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Shall we go out for lunch?<br />\n" +
                "&middot; D&ugrave;ng để ng&atilde; gi&aacute; trong khi mặc cả, mua b&aacute;n:<br />\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Shall we say : $ 50<br />\n" +
                "&middot; Thường được d&ugrave;ng với 1 văn bản mang t&iacute;nh ph&aacute;p qui buộc c&aacute;c b&ecirc;n phải thi h&agrave;nh điều khoản trong văn bản:<br />\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; All the students shall be responsible for proper execution of the dorm rule.<br />\n" +
                "<br />\n" +
                "Trong tiếng Anh b&igrave;nh d&acirc;n , người ta thay shall = must ở dạng c&acirc;u n&agrave;y. N&oacute; d&ugrave;ng để diễn đạt một h&agrave;nh động sẽ xảy ra ở một thời điểm nhất định trong tương lai nhưng kh&ocirc;ng x&aacute;c định cụ thể. Thường d&ugrave;ng với một số ph&oacute; từ chỉ thời gian như tomorrow, next + time, in the future, in future, from now on.</p>\n" +
                "<h4><span style=\"color: #0070c0;\"><a name=\"3.3.2\">3.3.2</a>&nbsp;Near Future (tương lai gần):</span></h4>\n" +
                "<p style=\"text-align: center;\"><strong><span style=\"color: #c00000;\">S + am / is / are + going to + [verb in simple form] + ...</span></strong></p>\n" +
                "<p>Diễn đạt một h&agrave;nh động sẽ xảy ra trong tương lai gần, thường d&ugrave;ng với c&aacute;c ph&oacute; từ dưới dạng: In a moment (l&aacute;t nữa), at 2 o'clock this afternoon....<br />\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; We&nbsp;<span style=\"text-decoration: underline;\">are going</span>&nbsp;to have a reception in a moment<br />\n" +
                "N&oacute; chỉ 1 việc chắc chắn sẽ phải xảy ra theo như dự t&iacute;nh cho d&ugrave; thời gian l&agrave; tương lai xa.<br />\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; We&nbsp;<span style=\"text-decoration: underline;\">are going</span>&nbsp;to take a TOEFL test next year.<br />\n" +
                "Ng&agrave;y nay người ta thường d&ugrave;ng present progressive.</p>\n" +
                "<h4><span style=\"color: #0070c0;\"><a name=\"3.3.3\">3.3.3</a>&nbsp;Future Progressive (thời tương lai tiếp diễn):</span></h4>\n" +
                "<p style=\"text-align: center;\"><strong><span style=\"color: #c00000;\">S + will / shall + be + [verb-ing] + ...</span></strong></p>\n" +
                "<p>&middot; D&ugrave;ng để diễn đạt một h&agrave;nh động sẽ xảy ra v&agrave;o một thời điểm nhất định trong tương lai.<br />\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; At 8:00 am tomorrow morning we&nbsp;<span style=\"text-decoration: underline;\">will be attending</span>&nbsp;the lecture.<br />\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Good luck with the exam! We&nbsp;<span style=\"text-decoration: underline;\">will be thinking</span>&nbsp;of you.<br />\n" +
                "&middot; D&ugrave;ng kết hợp với present progressive kh&aacute;c để diễn đạt hai h&agrave;nh động đang song song xảy ra. Một ở hiện tại, c&ograve;n một ở tương lai.<br />\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Now we&nbsp;<span style=\"text-decoration: underline;\">are learning</span>&nbsp;English here, but by this time tomorrow we&nbsp;<span style=\"text-decoration: underline;\">will be attending</span>&nbsp;the meeting at the office.<br />\n" +
                "&middot; Được d&ugrave;ng để đề cập đến c&aacute;c sự kiện tương lai đ&atilde; được x&aacute;c định hoặc quyết định (kh&ocirc;ng mang &yacute; nghĩa tiếp diễn).<br />\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Professor Baxter&nbsp;<span style=\"text-decoration: underline;\">will be giving</span>&nbsp;another lecture on Roman glass-making at the same time next week.<br />\n" +
                "&middot; Hoặc những sự kiện được mong đợi l&agrave; sẽ xảy ra theo một tiến tr&igrave;nh thường lệ (nhưng kh&ocirc;ng diễn đạt &yacute; định của c&aacute; nh&acirc;n người n&oacute;i).<br />\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; You&nbsp;<span style=\"text-decoration: underline;\">will be hearing</span>&nbsp;from my solicitor.<br />\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; I&nbsp;<span style=\"text-decoration: underline;\">will be seeing</span>&nbsp;you one of these days, I expect.<br />\n" +
                "&middot; Dự đo&aacute;n cho tương lai:<br />\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Don't phone now, they&nbsp;<span style=\"text-decoration: underline;\">will be having</span>&nbsp;dinner.<br />\n" +
                "&middot; Diễn đạt lời đề nghị nh&atilde; nhặn muốn biết về kế hoạch của người kh&aacute;c<br />\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span style=\"text-decoration: underline;\">Will</span>&nbsp;you&nbsp;<span style=\"text-decoration: underline;\">be staying</span>&nbsp;in here this evening? (&ocirc;ng c&oacute; dự định ở lại đ&acirc;y tối nay chứ ạ)</p>\n" +
                "<h4><span style=\"color: #0070c0;\"><a name=\"3.3.4\">3.3.4</a>&nbsp;Future Perfect (thời tương lai ho&agrave;n th&agrave;nh):</span></h4>\n" +
                "<p style=\"text-align: center;\"><strong><span style=\"color: #c00000;\">S + will / shall + have + [verb in participle] + ...</span></strong></p>\n" +
                "<p>D&ugrave;ng để chỉ một h&agrave;nh động sẽ phải được ho&agrave;n tất ở v&agrave;o một thời điểm nhất định trong tương lai. N&oacute; thường được d&ugrave;ng với trạng từ chỉ thời gian dưới dạng: by the end of....., by the time + sentence<br />\n" +
                "<br />\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; We&nbsp;<span style=\"text-decoration: underline;\">will have accomplished</span>&nbsp;the English grammar course&nbsp;<span style=\"text-decoration: underline;\">by the end of next week</span>.<br />\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span style=\"text-decoration: underline;\">By the time</span>&nbsp;human being migrates to the moon, most of the people alive today&nbsp;<span style=\"text-decoration: underline;\">will have died</span>.<br />\n" +
                "<br />\n" +
                "<br />\n" +
                "</p>\n" +
                "\n" +
                "\t</body>\n" +
                "</html>"));
        grammars.add(new Grammar("Sự hòa hợp giữa chủ ngữ và động từ", "<!DOCTYPE html>\n" +
                "<html>\n" +
                "    <head>\n" +
                "    </head>\n" +
                "    <body style=\"font-size:13px; text-align:justify\">\n" +
                "        <meta charset=\"UTF-8\" />\n" +
                "        <title>Ngữ Ph&aacute;p Tiếng Anh</title>\n" +
                "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\" />\n" +
                "        <h3><span style=\"color: #0070c0;\"><a name=\"4\">4</a>. Sự h&ograve;a hợp giữa chủ ngữ v&agrave; động từ</span></h3>\n" +
                "        <p>Trong một c&acirc;u tiếng Anh, chủ ngữ v&agrave; động từ phải ph&ugrave; hợp với nhau về ng&ocirc;i v&agrave; số (số &iacute;t hay số nhiều)</p>\n" +
                "        <span class=\"Apple-tab-span\" style=\"white-space: pre;\">\t</span>The worker <span style=\"text-decoration: underline;\">works</span> very well.<br />\n" +
                "        <span class=\"Apple-tab-span\" style=\"white-space: pre;\">\t</span>The workers  <span style=\"text-decoration: underline;\">work</span> very well.\n" +
                "        <h3><span style=\"color: #0070c0;\"><a name=\"4.1\">4.1</a>&nbsp;C&aacute;c trường hợp chủ ngữ đứng t&aacute;ch khỏi động từ</span></h3>\n" +
                "        <p>Trong c&acirc;u tiếng Anh, c&oacute; nhiều trường hợp rất kh&oacute; x&aacute;c định được đ&acirc;u l&agrave; chủ ngữ của c&acirc;u do chủ ngữ v&agrave; động từ kh&ocirc;ng đi liền với nhau.<br />\n" +
                "        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span style=\"text-decoration: underline;\">The boys</span>&nbsp;in the room&nbsp;<span style=\"text-decoration: underline;\">are playing</span>&nbsp;chess.<br />\n" +
                "        Th&ocirc;ng thường trong c&aacute;c trường hợp đ&oacute;, một ngữ giới từ (một giới từ mở đầu v&agrave; c&aacute;c danh từ theo sau &ndash; in the room) thường nằm giữa chủ ngữ v&agrave; động từ. C&aacute;c ngữ giới từ n&agrave;y kh&ocirc;ng ảnh hưởng đến việc chia động từ.<br />\n" +
                "        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span style=\"text-decoration: underline;\">The study</span>&nbsp;of languages&nbsp;<span style=\"text-decoration: underline;\">is</span>&nbsp;very interesting.<br />\n" +
                "        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span style=\"text-decoration: underline;\">Serveral theories</span>&nbsp;on this subject&nbsp;<span style=\"text-decoration: underline;\">have been proposed</span>.<br />\n" +
                "        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span style=\"text-decoration: underline;\">The view</span>&nbsp;of these disciplines&nbsp;<span style=\"text-decoration: underline;\">varies</span>&nbsp;from time to time.<br />\n" +
                "        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span style=\"text-decoration: underline;\">The danger</span>&nbsp;of forest fires&nbsp;<span style=\"text-decoration: underline;\">is</span>&nbsp;not to be taken lightly.<br />\n" +
                "        <br />\n" +
                "        Ch&uacute; &yacute; rằng trong c&aacute;c v&iacute; dụ tr&ecirc;n c&aacute;c danh từ nằm trong ngữ giới từ đều tr&aacute;i ngược với chủ ngữ về số &iacute;t / số nhiều nhưng động từ lu&ocirc;n được chia theo chủ ngữ ch&iacute;nh.<br />\n" +
                "        <br />\n" +
                "        C&aacute;c cụm từ sau c&ugrave;ng với c&aacute;c danh từ đi theo sau n&oacute; tạo n&ecirc;n hiện tường đồng chủ ngữ. Ch&uacute;ng đứng giữa chủ ngữ v&agrave; động từ, ph&acirc;n t&aacute;ch khỏi 2 th&agrave;nh phần đ&oacute; bởi dấu phảy. Ch&uacute;ng cũng kh&ocirc;ng c&oacute; ảnh hưởng g&igrave; đến việc chia động từ.</p>\n" +
                "        <table border=\"0\" width=\"100%\">\n" +
                "            <tbody>\n" +
                "                <tr>\n" +
                "                    <td style=\"width: 158px;\">Together with</td>\n" +
                "                    <td style=\"width: 158px;\">along with</td>\n" +
                "                    <td style=\"width: 158px;\">accompanied by</td>\n" +
                "                    <td style=\"width: 157px;\">as well as</td>\n" +
                "                </tr>\n" +
                "            </tbody>\n" +
                "        </table>\n" +
                "        <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span style=\"text-decoration: underline;\">Mary</span>, along with her manager and some friends,&nbsp;<span style=\"text-decoration: underline;\">is going</span>&nbsp;to a party tonight.<br />\n" +
                "        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span style=\"text-decoration: underline;\">Mr. Robbins</span>, accompanied by her wife and children,&nbsp;<span style=\"text-decoration: underline;\">is arriving</span>&nbsp;tonight.<br />\n" +
                "        <br />\n" +
                "        Nếu 2 danh từ l&agrave;m chủ ngữ nối với nhau bằng&nbsp;<strong>and</strong>&nbsp;th&igrave; động từ phải chia ở ng&ocirc;i thứ 3 số nhiều (tương đương với they)<br />\n" +
                "        <br />\n" +
                "        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span style=\"text-decoration: underline;\">Mary and her manager</span>&nbsp;<span style=\"text-decoration: underline;\">are going</span>&nbsp;to a party tonight.<br />\n" +
                "        <br />\n" +
                "        Nhưng nếu 2 đồng chủ ngữ nối với nhau bằng&nbsp;<strong>or</strong>&nbsp;th&igrave; động từ phải chia theo danh từ đứng sau&nbsp;<strong>or</strong>. Nếu danh từ đ&oacute; l&agrave; số &iacute;t th&igrave; động từ phải chia số &iacute;t v&agrave; ngược lại.<br />\n" +
                "        <br />\n" +
                "        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span style=\"text-decoration: underline;\">Mary</span>&nbsp;<strong>or</strong>&nbsp;<span style=\"text-decoration: underline;\">her manager</span>&nbsp;<span style=\"text-decoration: underline;\">is going</span>&nbsp;to answer the press interview.</p>\n" +
                "        <h3><span style=\"color: #0070c0;\"><a name=\"4.2\">4.2</a>&nbsp;C&aacute;c từ lu&ocirc;n đi với danh từ hoặc đại từ số &iacute;t</span></h3>\n" +
                "        <p>Đ&oacute; l&agrave; c&aacute;c danh từ ở bảng sau (c&ograve;n gọi l&agrave; c&aacute;c đại từ phiếm chỉ).</p>\n" +
                "        <table border=\"1\" width=\"100%\">\n" +
                "            <tbody>\n" +
                "                <tr>\n" +
                "                    <td style=\"width: 209px;\">any + singular noun</td>\n" +
                "                    <td style=\"width: 209px;\">no + singular noun</td>\n" +
                "                    <td style=\"width: 214px;\">some + singular noun</td>\n" +
                "                </tr>\n" +
                "                <tr>\n" +
                "                    <td style=\"width: 209px;\">anybody<br />\n" +
                "                    anyone<br />\n" +
                "                    anything</td>\n" +
                "                    <td style=\"width: 209px;\">nobody<br />\n" +
                "                    no one<br />\n" +
                "                    nothing</td>\n" +
                "                    <td style=\"width: 214px;\">somebody<br />\n" +
                "                    someone<br />\n" +
                "                    something</td>\n" +
                "                </tr>\n" +
                "                <tr>\n" +
                "                    <td colspan=\"3\" style=\"width: 644px;\">every + singular noun&nbsp;<br />\n" +
                "                    everybody&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; everyone&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; everything&nbsp;</td>\n" +
                "                </tr>\n" +
                "                <tr>\n" +
                "                    <td style=\"width: 209px;\">each&nbsp;</td>\n" +
                "                    <td style=\"width: 209px;\">either *</td>\n" +
                "                    <td style=\"width: 214px;\">neither *</td>\n" +
                "                </tr>\n" +
                "            </tbody>\n" +
                "        </table>\n" +
                "        <p>*&nbsp;<em>Either</em>&nbsp;v&agrave;&nbsp;<em>neither</em>&nbsp;l&agrave; số &iacute;t nếu ch&uacute;ng kh&ocirc;ng đi với&nbsp;<em>or</em>&nbsp;hoặc&nbsp;<em>nor</em>. Either (c&oacute; nghĩa 1 trong 2) chỉ d&ugrave;ng cho 2 người hoặc 2 vật. Nếu 3 người (vật) trở l&ecirc;n phải d&ugrave;ng&nbsp;<em>any</em>. Neither (kh&ocirc;ng một ai trong hai) chỉ d&ugrave;ng cho 2 người, 2 vật. Nếu 3 người (vật) trở l&ecirc;n d&ugrave;ng&nbsp;<em>not any</em>.</p>\n" +
                "        <blockquote>\n" +
                "        <p><span style=\"text-decoration: underline;\">Everybody</span>&nbsp;who&nbsp;<span style=\"text-decoration: underline;\">wants</span>&nbsp;to buy a ticket should be in this line.<br />\n" +
                "        <span style=\"text-decoration: underline;\">Something</span>&nbsp;<span style=\"text-decoration: underline;\">is</span>&nbsp;in my eye.<br />\n" +
                "        <span style=\"text-decoration: underline;\">Anybody</span>&nbsp;who&nbsp;<span style=\"text-decoration: underline;\">has</span>&nbsp;lost his ticket should report to the desk.<br />\n" +
                "        <span style=\"text-decoration: underline;\">Neither</span>&nbsp;of his pens&nbsp;<span style=\"text-decoration: underline;\">is</span>&nbsp;able to be used.<br />\n" +
                "        If&nbsp;<span style=\"text-decoration: underline;\">either</span>&nbsp;of you&nbsp;<span style=\"text-decoration: underline;\">takes</span>&nbsp;a vacation now, we will not be able to finish the work.<br />\n" +
                "        <span style=\"text-decoration: underline;\">No problem</span>&nbsp;<span style=\"text-decoration: underline;\">is</span>&nbsp;harder than this one.<br />\n" +
                "        <span style=\"text-decoration: underline;\">Nobody</span>&nbsp;<span style=\"text-decoration: underline;\">works</span>&nbsp;harder than John does.</p>\n" +
                "        </blockquote>\n" +
                "        <h3><span style=\"color: #0070c0;\"><a name=\"4.3\">4.3</a>&nbsp;C&aacute;ch sử dụng None v&agrave; No</span></h3>\n" +
                "        <p>None v&agrave; No đều d&ugrave;ng được với cả danh từ số &iacute;t v&agrave; số nhiều.&nbsp;<br />\n" +
                "        &middot; Nếu sau None of the l&agrave; một danh từ kh&ocirc;ng đếm được th&igrave; động từ phải ở ng&ocirc;i thứ 3 số &iacute;t. Nếu sau n&oacute; l&agrave; một danh từ số nhiều th&igrave; động từ phải chia ở ng&ocirc;i thứ 3 số nhiều.</p>\n" +
                "        <blockquote><blockquote>\n" +
                "        <p style=\"border-style: solid;\">&nbsp;&nbsp;&nbsp; None of the + non-count noun + singular verb<br />\n" +
                "        &nbsp;&nbsp;&nbsp; None of the + plural count noun + plural verb</p>\n" +
                "        </blockquote>\n" +
                "        <p><span style=\"text-decoration: underline;\">None</span>&nbsp;of the counterfeit&nbsp;<span style=\"text-decoration: underline;\">money</span>&nbsp;<span style=\"text-decoration: underline;\">has been</span>&nbsp;found.&nbsp;<br />\n" +
                "        <span style=\"text-decoration: underline;\">None</span>&nbsp;of the&nbsp;<span style=\"text-decoration: underline;\">students</span>&nbsp;<span style=\"text-decoration: underline;\">have finished</span>&nbsp;the exam yet.</p>\n" +
                "        </blockquote>\n" +
                "        <p>&middot; Nếu sau No l&agrave; một danh từ đếm được số &iacute;t hoặc kh&ocirc;ng đếm được th&igrave; động từ phải ở ng&ocirc;i thứ 3 số &iacute;t. Nếu sau n&oacute; l&agrave; một danh từ số nhiều th&igrave; động từ phải ở ng&ocirc;i thứ 3 số nhiều</p>\n" +
                "        <blockquote><blockquote>\n" +
                "        <p style=\"border-style: solid;\">&nbsp;&nbsp;&nbsp; No + {singular noun / non-count noun} + singular verb<br />\n" +
                "        &nbsp;&nbsp;&nbsp; No + plural noun + plural verb</p>\n" +
                "        </blockquote>\n" +
                "        <p><span style=\"text-decoration: underline;\">No example</span>&nbsp;<span style=\"text-decoration: underline;\">is</span>&nbsp;relevant to this case.&nbsp;&nbsp;<br />\n" +
                "        <span style=\"text-decoration: underline;\">No examples</span>&nbsp;<span style=\"text-decoration: underline;\">are</span>&nbsp;relevant to this case.</p>\n" +
                "        </blockquote>\n" +
                "        <h3><span style=\"color: #0070c0;\"><a name=\"4.4\">4.4</a>&nbsp;C&aacute;ch sử dụng cấu tr&uacute;c either... or (hoặc...hoặc) v&agrave; neither... nor (kh&ocirc;ng...m&agrave; cũng kh&ocirc;ng)</span></h3>\n" +
                "        <p>Điều cần lưu &yacute; nhất khi sử dụng cấu tr&uacute;c n&agrave;y l&agrave; động từ phải chia theo danh từ đi sau&nbsp;<em>or</em>&nbsp;hoặc&nbsp;<em>nor</em>. Nếu danh từ đ&oacute; l&agrave; số &iacute;t th&igrave; động từ chia ở ng&ocirc;i thứ 3 số &iacute;t v&agrave; ngược lại. Nếu or hoặc nor xuất hiện một m&igrave;nh (kh&ocirc;ng c&oacute; either hoặc neither) th&igrave; cũng &aacute;p dụng quy tắc tương tự (như đ&atilde; đề cập ở phần tr&ecirc;n)</p>\n" +
                "        <p style=\"text-align: center;\"><strong><span style=\"color: #c00000;\">{neither/either} + noun + {nor/or} + plural noun + plural verb</span></strong><br />\n" +
                "        <strong><span style=\"color: #c00000;\">{neither/either} + noun + {nor/or} + singular noun + singular verb</span></strong></p>\n" +
                "        <blockquote>\n" +
                "        <p><span style=\"text-decoration: underline;\">Neither</span>&nbsp;John&nbsp;<span style=\"text-decoration: underline;\">nor</span>&nbsp;<span style=\"text-decoration: underline;\">his friends</span>&nbsp;<span style=\"text-decoration: underline;\">are going</span>&nbsp;to the beach today.<br />\n" +
                "        <span style=\"text-decoration: underline;\">Either</span>&nbsp;John&nbsp;<span style=\"text-decoration: underline;\">or</span>&nbsp;<span style=\"text-decoration: underline;\">his friends</span>&nbsp;<span style=\"text-decoration: underline;\">are going</span>&nbsp;to the beach today.<br />\n" +
                "        <span style=\"text-decoration: underline;\">Neither</span>&nbsp;the boys&nbsp;<span style=\"text-decoration: underline;\">nor</span>&nbsp;<span style=\"text-decoration: underline;\">Carmen</span>&nbsp;<span style=\"text-decoration: underline;\">has seen</span>&nbsp;this movie before.<br />\n" +
                "        <span style=\"text-decoration: underline;\">Either</span>&nbsp;John&nbsp;<span style=\"text-decoration: underline;\">or</span>&nbsp;<span style=\"text-decoration: underline;\">Bill</span>&nbsp;<span style=\"text-decoration: underline;\">is going</span>&nbsp;to the beach today.<br />\n" +
                "        <span style=\"text-decoration: underline;\">Neither</span>&nbsp;the director&nbsp;<span style=\"text-decoration: underline;\">nor</span>&nbsp;<span style=\"text-decoration: underline;\">the secretary</span>&nbsp;<span style=\"text-decoration: underline;\">wants</span>&nbsp;to leave yet.</p>\n" +
                "        </blockquote>\n" +
                "        <h3><span style=\"color: #0070c0;\"><a name=\"4.5\">4.5</a>&nbsp;V-ing l&agrave;m chủ ngữ</span></h3>\n" +
                "        <p>Khi V-ing d&ugrave;ng l&agrave;m chủ ngữ th&igrave; động từ cũng phải chia ở ng&ocirc;i thứ 3 số &iacute;t.</p>\n" +
                "        <blockquote>\n" +
                "        <p><span style=\"text-decoration: underline;\">Knowing</span>&nbsp;her&nbsp;<span style=\"text-decoration: underline;\">has made</span>&nbsp;him what he is.&nbsp;<br />\n" +
                "        <span style=\"text-decoration: underline;\">Not studying</span>&nbsp;<span style=\"text-decoration: underline;\">has caused</span>&nbsp;him many problems.&nbsp;<br />\n" +
                "        <span style=\"text-decoration: underline;\">Washing</span>&nbsp;with special cream&nbsp;<span style=\"text-decoration: underline;\">is</span>&nbsp;recommended for scalp infection.&nbsp;<br />\n" +
                "        <span style=\"text-decoration: underline;\">Being</span>&nbsp;cordial&nbsp;<span style=\"text-decoration: underline;\">is</span>&nbsp;one of his greatest assets.&nbsp;<br />\n" +
                "        <span style=\"text-decoration: underline;\">Writing</span>&nbsp;many letters&nbsp;<span style=\"text-decoration: underline;\">makes</span>&nbsp;her happy.</p>\n" +
                "        </blockquote>\n" +
                "        <p>Người ta sẽ d&ugrave;ng V-ing khi muốn diễn đạt 1 h&agrave;nh động cụ thể xảy ra nhất thời nhưng khi muốn diễn đạt bản chất của sự vật, sự việc th&igrave; phải d&ugrave;ng danh từ<br />\n" +
                "        <br />\n" +
                "        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span style=\"text-decoration: underline;\">Dieting</span>&nbsp;is very popular today.<br />\n" +
                "        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span style=\"text-decoration: underline;\">Diet</span>&nbsp;is for those who suffer from a cerain disease.<br />\n" +
                "        <br />\n" +
                "        Động từ nguy&ecirc;n thể cũng c&oacute; thể d&ugrave;ng l&agrave;m chủ ngữ v&agrave; động từ sau n&oacute; sẽ chia ở ng&ocirc;i thứ 3 số &iacute;t. Nhưng người ta thường d&ugrave;ng chủ ngữ giả&nbsp;<em>it</em>&nbsp;để mở đầu c&acirc;u.<br />\n" +
                "        <br />\n" +
                "        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span style=\"text-decoration: underline;\">To find</span>&nbsp;the book&nbsp;<span style=\"text-decoration: underline;\">is</span>&nbsp;necessary for him = It is necessary for him to find the book.</p>\n" +
                "        <h3><span style=\"color: #0070c0;\"><a name=\"4.6\">4.6</a>&nbsp;C&aacute;c danh từ tập thể</span></h3>\n" +
                "        <p>Đ&oacute; l&agrave; c&aacute;c danh từ ở bảng sau d&ugrave;ng để chỉ 1 nh&oacute;m người hoặc 1 tổ chức nhưng tr&ecirc;n thực tế ch&uacute;ng l&agrave; những danh từ số &iacute;t, do vậy c&aacute;c đại từ v&agrave; động từ theo sau ch&uacute;ng cũng ở ng&ocirc;i thứ 3 số &iacute;t.</p>\n" +
                "        <table border=\"1\" width=\"100%\">\n" +
                "            <tbody>\n" +
                "                <tr>\n" +
                "                    <td style=\"width: 209px;\">Congress<br />\n" +
                "                    family<br />\n" +
                "                    group<br />\n" +
                "                    committee<br />\n" +
                "                    class</td>\n" +
                "                    <td style=\"width: 209px;\">Organization<br />\n" +
                "                    team<br />\n" +
                "                    army<br />\n" +
                "                    club<br />\n" +
                "                    crowd</td>\n" +
                "                    <td style=\"width: 214px;\">Government<br />\n" +
                "                    jury<br />\n" +
                "                    majority*<br />\n" +
                "                    minority<br />\n" +
                "                    public</td>\n" +
                "                </tr>\n" +
                "            </tbody>\n" +
                "        </table>\n" +
                "        <blockquote>\n" +
                "        <p><span style=\"text-decoration: underline;\">The committee</span>&nbsp;<span style=\"text-decoration: underline;\">has</span>&nbsp;met, and it has rejected the proposal.<br />\n" +
                "        <span style=\"text-decoration: underline;\">The family</span>&nbsp;<span style=\"text-decoration: underline;\">was</span>&nbsp;elated by the news.<br />\n" +
                "        <span style=\"text-decoration: underline;\">The crowd</span>&nbsp;<span style=\"text-decoration: underline;\">was</span>&nbsp;wild with excitement<br />\n" +
                "        <span style=\"text-decoration: underline;\">Congress</span>&nbsp;<span style=\"text-decoration: underline;\">has</span>&nbsp;initiated a new plan to combat inflation.<br />\n" +
                "        <span style=\"text-decoration: underline;\">The organization</span>&nbsp;<span style=\"text-decoration: underline;\">has</span>&nbsp;lot many members this year.<br />\n" +
                "        <span style=\"text-decoration: underline;\">Our team</span>&nbsp;<span style=\"text-decoration: underline;\">is</span>&nbsp;going to win the game.</p>\n" +
                "        </blockquote>\n" +
                "        <p>Tuy nhi&ecirc;n nếu c&aacute;c th&agrave;nh vi&ecirc;n trong nh&oacute;m đang hoạt động ri&ecirc;ng rẽ, động từ sẽ chia ở ng&ocirc;i thứ 3 số nhiều:</p>\n" +
                "        <blockquote>\n" +
                "        <p>Congress votes for the bill. (Quốc hội bỏ phiếu cho dự luật, gồm tất cả mọi người)<br />\n" +
                "        Congress are discussing about the bill. (Quốc hội đang tranh luận về dự luật, tức l&agrave; một số t&aacute;n th&agrave;nh, một số phản đối. Thi TOEFL kh&ocirc;ng bắt lỗi n&agrave;y).</p>\n" +
                "        </blockquote>\n" +
                "        <p>* Danh từ majority được d&ugrave;ng tuỳ theo th&agrave;nh phần sau n&oacute; để chia động từ<br />\n" +
                "        The majority + singular verb<br />\n" +
                "        The majority of the + plural noun + plural verb<br />\n" +
                "        <br />\n" +
                "        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span style=\"text-decoration: underline;\">The majority</span>&nbsp;<span style=\"text-decoration: underline;\">believes</span>&nbsp;that we are in no danger.<br />\n" +
                "        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span style=\"text-decoration: underline;\">The majority of the students</span>&nbsp;<span style=\"text-decoration: underline;\">believe</span>&nbsp;him to be innocent.<br />\n" +
                "        <br />\n" +
                "        &middot;&nbsp;<em>The police/the sheep/the fish</em>&nbsp;+ plural verb.<br />\n" +
                "        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span style=\"text-decoration: underline;\">The sheep</span>&nbsp;<span style=\"text-decoration: underline;\">are</span>&nbsp;breaking away<br />\n" +
                "        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span style=\"text-decoration: underline;\">The police</span>&nbsp;<span style=\"text-decoration: underline;\">come</span>&nbsp;only to see the dead bodies and a ruin in the bank<br />\n" +
                "        &middot;&nbsp;<em>A couple</em>&nbsp;+ singular verb<br />\n" +
                "        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; A couple is walking on the path<br />\n" +
                "        &middot;&nbsp;<em>The couple</em>&nbsp;+ plural verb<br />\n" +
                "        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; The couple are racing their horses through the meadow.<br />\n" +
                "        &middot; C&aacute;c cụm từ ở nh&oacute;m sau chỉ một nh&oacute;m động vật hoặc gia s&uacute;c. Cho d&ugrave; sau giới từ&nbsp;<em>of</em>&nbsp;l&agrave; danh từ số nhiều th&igrave; động từ vẫn chia theo ng&ocirc;i chủ ngữ ch&iacute;nh &ndash; ng&ocirc;i thứ 3 số &iacute;t:&nbsp;<em>flock of birds/ sheep, school of fish, herd of cattle, pride of lions, pack of dogs&nbsp;</em><br />\n" +
                "        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span style=\"text-decoration: underline;\">The flock of birds</span>&nbsp;is circling overhead.<br />\n" +
                "        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span style=\"text-decoration: underline;\">The herd of casttle</span>&nbsp;is breaking away.<br />\n" +
                "        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span style=\"text-decoration: underline;\">A school of fish</span>&nbsp;is being attacked by sharks.<br />\n" +
                "        &middot; Tất cả c&aacute;c danh từ tập thể chỉ thời gian, tiền bạc, số đo, ... khi được đề cập đến như một thể thống nhất th&igrave; đều được xem l&agrave; một danh từ số &iacute;t. Do đ&oacute; c&aacute;c động từ v&agrave; đại từ theo sau ch&uacute;ng phải ở ng&ocirc;i thứ 3 số &iacute;t.<br />\n" +
                "        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span style=\"text-decoration: underline;\">Twenty-five dollars</span>&nbsp;is too much for the meal.<br />\n" +
                "        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span style=\"text-decoration: underline;\">Fifty minutes</span>&nbsp;isn&rsquo;t enough time to finish this test<br />\n" +
                "        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span style=\"text-decoration: underline;\">Twenty dollars</span>&nbsp;is all I can afford to pay for that radio.<br />\n" +
                "        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span style=\"text-decoration: underline;\">Two miles</span>&nbsp;is too much to run in one day.<br />\n" +
                "        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; He has contributed $50, and now he wants to contribute&nbsp;<span style=\"text-decoration: underline;\">another fifty</span>.</p>\n" +
                "        <h3><span style=\"color: #0070c0;\"><a name=\"4.7\">4.7</a>&nbsp;C&aacute;ch sử dụng a number of, the number of:</span></h3>\n" +
                "        <p>A number of = &ldquo;Một số những ...&rdquo;, đi với danh từ số nhiều, động từ chia ở số nhiều.&nbsp;</p>\n" +
                "        <div style=\"text-align: center;\"><center>\n" +
                "        <table border=\"1\" width=\"69%\">\n" +
                "            <tbody>\n" +
                "                <tr>\n" +
                "                    <td style=\"width: 441px;\">\n" +
                "                    <p style=\"text-align: center;\">A number of + plural noun + plural verb</p>\n" +
                "                    </td>\n" +
                "                </tr>\n" +
                "            </tbody>\n" +
                "        </table>\n" +
                "        </center></div>\n" +
                "        <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span style=\"text-decoration: underline;\">A number of students</span>&nbsp;<span style=\"text-decoration: underline;\">are going</span>&nbsp;to the class picnic (Một số sinh vi&ecirc;n sẽ đi ...)&nbsp;<br />\n" +
                "        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span style=\"text-decoration: underline;\">A number of applicants</span>&nbsp;<span style=\"text-decoration: underline;\">have already been</span>&nbsp;interviewed.<br />\n" +
                "        <br />\n" +
                "        The number of = &ldquo;Số lượng những ...&rdquo;, đi với danh từ số nhiều, động từ vẫn ở ng&ocirc;i thứ 3 số &iacute;t.&nbsp;</p>\n" +
                "        <div style=\"text-align: center;\"><center>\n" +
                "        <table border=\"1\" width=\"68%\">\n" +
                "            <tbody>\n" +
                "                <tr>\n" +
                "                    <td style=\"width: 434px;\">\n" +
                "                    <p style=\"text-align: center;\">The number of + plural noun + singular verb...</p>\n" +
                "                    </td>\n" +
                "                </tr>\n" +
                "            </tbody>\n" +
                "        </table>\n" +
                "        </center></div>\n" +
                "        <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span style=\"text-decoration: underline;\">The number of days</span>&nbsp;in a week&nbsp;<span style=\"text-decoration: underline;\">is</span>&nbsp;seven. (Số lượng ng&agrave;y trong tuần l&agrave; 7)<br />\n" +
                "        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span style=\"text-decoration: underline;\">The number of residents</span>&nbsp;who have been questioned on this matter&nbsp;<span style=\"text-decoration: underline;\">is</span>&nbsp;quite small.</p>\n" +
                "        <h3><a name=\"4.8\">4.8</a>&nbsp;C&aacute;c danh từ lu&ocirc;n ở số nhiều</h3>\n" +
                "        <p>Bảng sau l&agrave; những danh từ bao giờ cũng ở h&igrave;nh th&aacute;i số nhiều v&igrave; ch&uacute;ng bao gồm 2 thực thể n&ecirc;n c&aacute;c đại từ v&agrave; động từ đi c&ugrave;ng với ch&uacute;ng cũng phải ở số nhiều.</p>\n" +
                "        <table border=\"0\" width=\"100%\">\n" +
                "            <tbody>\n" +
                "                <tr>\n" +
                "                    <td style=\"width: 210px;\">scissors<br />\n" +
                "                    shorts<br />\n" +
                "                    pants</td>\n" +
                "                    <td style=\"width: 210px;\">jeans<br />\n" +
                "                    tongs<br />\n" +
                "                    trousers</td>\n" +
                "                    <td style=\"width: 216px;\">eyeglasses<br />\n" +
                "                    pliers<br />\n" +
                "                    tweezers</td>\n" +
                "                </tr>\n" +
                "            </tbody>\n" +
                "        </table>\n" +
                "        <p>Nếu muốn ch&uacute;ng th&agrave;nh ng&ocirc;i số &iacute;t phải d&ugrave;ng&nbsp;<em>a pair of</em>...<br />\n" +
                "        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span style=\"text-decoration: underline;\">The pants</span>&nbsp;<span style=\"text-decoration: underline;\">are</span>&nbsp;in the drawer.<br />\n" +
                "        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span style=\"text-decoration: underline;\">A pair of pants</span>&nbsp;<span style=\"text-decoration: underline;\">is</span>&nbsp;in the drawer.<br />\n" +
                "        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span style=\"text-decoration: underline;\">These scissors</span>&nbsp;<span style=\"text-decoration: underline;\">are</span>&nbsp;dull. (C&aacute;i k&eacute;o n&agrave;y c&ugrave;n. Ch&uacute; &yacute; chỉ c&oacute; 1 c&aacute;i k&eacute;o nhưng cũng d&ugrave;ng với these)</p>\n" +
                "        <h3><span style=\"color: #0070c0;\"><a name=\"4.9\">4.9</a>&nbsp;C&aacute;ch d&ugrave;ng there is, there are</span></h3>\n" +
                "        <p>Được d&ugrave;ng để chỉ sự tồn tại của người hoặc vật tại một nơi n&agrave;o đ&oacute;. Chủ ngữ thật của c&acirc;u l&agrave; l&agrave; danh từ đi sau động từ. Nếu n&oacute; l&agrave; danh từ số &iacute;t th&igrave; động từ&nbsp;<em>to be</em>&nbsp;chia ở ng&ocirc;i thứ 3 số &iacute;t v&agrave; ngược lại. Mọi biến đổi về thời v&agrave; thể đều ở&nbsp;<em>to be</em>&nbsp;c&ograve;n&nbsp;<em>there</em>&nbsp;giữ nguy&ecirc;n.</p>\n" +
                "        <p style=\"text-align: center;\"><strong><span style=\"color: #c00000;\">{There is/ There was/There has been} + singular subject (or non-count) ...</span></strong></p>\n" +
                "        <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span style=\"text-decoration: underline;\">There has been</span>&nbsp;<span style=\"text-decoration: underline;\">an increase</span>&nbsp;in the importation of foreign cars.<br />\n" +
                "        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span style=\"text-decoration: underline;\">Threre is</span>&nbsp;<span style=\"text-decoration: underline;\">a storm</span>&nbsp;approaching.<br />\n" +
                "        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span style=\"text-decoration: underline;\">There was</span>&nbsp;<span style=\"text-decoration: underline;\">an accident</span>&nbsp;last night.<br />\n" +
                "        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span style=\"text-decoration: underline;\">There was</span>&nbsp;<span style=\"text-decoration: underline;\">water</span>&nbsp;on the floor.</p>\n" +
                "        <p style=\"text-align: center;\"><strong><span style=\"color: #c00000;\">{There are/ There were/There have been} + plural subject ...</span></strong></p>\n" +
                "        <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span style=\"text-decoration: underline;\">There have been</span>&nbsp;<span style=\"text-decoration: underline;\">a number of telephone calls</span>&nbsp;today.<br />\n" +
                "        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span style=\"text-decoration: underline;\">There were</span>&nbsp;<span style=\"text-decoration: underline;\">too many people</span>&nbsp;at the party.</p>\n" +
                "        <p><strong><span style=\"text-decoration: underline;\">Lưu &yacute;:</span></strong></p>\n" +
                "        <ul>\n" +
                "            <li>C&aacute;c cấu tr&uacute;c: there is certain/ sure/ likely/ bound to be = chắc chắn l&agrave; sẽ c&oacute;&nbsp;<br />\n" +
                "            <span style=\"text-decoration: underline;\">There is sure to be</span>&nbsp;trouble when she gets his letter. (Chắc chắn l&agrave; sẽ c&oacute; rắc rối khi c&ocirc; ấy nhận được thư anh ta)<br />\n" +
                "            Do you think&nbsp;<span style=\"text-decoration: underline;\">there is likely to be</span>&nbsp;snow. (Anh cho rằng chắc chắn sẽ c&oacute; tuyết chứ)</li>\n" +
                "            <li>Trong dạng tiếng Anh quy chuẩn hoặc văn chương một số c&aacute;c động từ kh&aacute;c ngo&agrave;i to be cũng được sử dụng với there:&nbsp;<br />\n" +
                "            Động từ trạng th&aacute;i:&nbsp;<em>stand/ lie/ remain/ exist/ live</em><br />\n" +
                "            Động từ chỉ sự đến:&nbsp;<em>enter/ go/ come/ follow/ develop</em></li>\n" +
                "        </ul>\n" +
                "        <p style=\"text-align: center;\"><strong><span style=\"color: #c00000;\">There + verb {of state/of arrival} + noun as subject</span></strong></p>\n" +
                "        <blockquote>\n" +
                "        <p>In a small town in Germany&nbsp;<span style=\"text-decoration: underline;\">there once lived</span>&nbsp;a poor shoemaker. (Tại một thị trấn nhỏ ở Đức c&oacute; một &ocirc;ng thợ gi&agrave;y ngh&egrave;o sống ở đ&oacute;)<br />\n" +
                "        <span style=\"text-decoration: underline;\">There remains</span>&nbsp;nothing more to be done . (Chả c&ograve;n c&oacute; g&igrave; nữa m&agrave; l&agrave;m)<br />\n" +
                "        Suddenly&nbsp;<span style=\"text-decoration: underline;\">there entered</span>&nbsp;a strange figure dressed all in black.&nbsp; (Bỗng c&oacute; một h&igrave;nh b&oacute;ng k&igrave; lạ mặc to&agrave;n đồ đen đi v&agrave;o)<br />\n" +
                "        <span style=\"text-decoration: underline;\">There followed</span>&nbsp;an uncomfortable silence. (Sau đ&oacute; l&agrave; một sự im lặng đến kh&oacute; chịu)</p>\n" +
                "        </blockquote>\n" +
                "        <ul>\n" +
                "            <li>There + subject pronoun + go/ come/ be: k&igrave;a/ thế l&agrave;/ rồi th&igrave;&nbsp;<br />\n" +
                "            <span style=\"text-decoration: underline;\">There he comes</span>&nbsp; (Anh ta đ&atilde; đến rồi kia k&igrave;a)<br />\n" +
                "            <span style=\"text-decoration: underline;\">There you are</span>, I have been waiting for you for over an hour.&nbsp; (Anh đ&acirc;y rồi, t&ocirc;i đang chờ anh đến hơn một tiếng rồi đấy)</li>\n" +
                "        </ul>\n" +
                "        <div><br />\n" +
                "        </div>\n" +
                "    </body>\n" +
                "</html>"));
        grammars.add(new Grammar("Đại từ", "<!DOCTYPE html>\n" +
                "<html>\n" +
                "\t<head>\n" +
                "\t\t<meta charset=\"UTF-8\">\n" +
                "\t\t<title>Ngữ Pháp Tiếng Anh</title>\n" +
                "\t\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\"> \t\t\n" +
                "\t</head>\n" +
                "\t<body style=\"font-size:13px; text-align:justify\">\n" +
                "<h3><span style=\"color: #0070c0;\"><a name=\"5\">5</a>. Đại từ</span></h3>\n" +
                "<p>Đại từ được chia l&agrave;m 5 loại với c&aacute;c chức năng sử dụng kh&aacute;c nhau, bao gồm:</p>\n" +
                "<h3><span style=\"color: #0070c0;\"><a name=\"5.1\">5.1</a>&nbsp;Subject pronoun (Đại từ nh&acirc;n xưng chủ ngữ)</span></h3>\n" +
                "<div style=\"text-align: center;\"><center>\n" +
                "<table border=\"1\" width=\"43%\">\n" +
                "    <tbody>\n" +
                "        <tr>\n" +
                "            <td style=\"width: 133px;\">\n" +
                "            <p style=\"text-align: center;\">I<br />\n" +
                "            You<br />\n" +
                "            He<br />\n" +
                "            She<br />\n" +
                "            It</p>\n" +
                "            </td>\n" +
                "            <td style=\"width: 132px;\">\n" +
                "            <p style=\"text-align: center;\">We<br />\n" +
                "            You</p>\n" +
                "            <p style=\"text-align: center;\">They</p>\n" +
                "            </td>\n" +
                "        </tr>\n" +
                "    </tbody>\n" +
                "</table>\n" +
                "</center></div>\n" +
                "<p>Đại từ nh&acirc;n xưng chủ ngữ (c&ograve;n gọi l&agrave; đại từ nh&acirc;n xưng) thường đứng ở vị tr&iacute; chủ ngữ trong c&acirc;u hoặc đứng sau động từ&nbsp;<em>be</em>, đằng sau c&aacute;c ph&oacute; từ so s&aacute;nh như&nbsp;<em>than</em>,&nbsp;<em>as, that...</em></p>\n" +
                "<blockquote>\n" +
                "<p><span style=\"text-decoration: underline;\">I</span>&nbsp;am going to the store.<br />\n" +
                "<span style=\"text-decoration: underline;\">We</span>&nbsp;have lived here for twenty years.<br />\n" +
                "The teachers who were invited to the party&nbsp;<span style=\"text-decoration: underline;\">were</span>&nbsp;George, Bill and&nbsp;<span style=\"text-decoration: underline;\">I</span>.<br />\n" +
                "It&nbsp;<span style=\"text-decoration: underline;\">was</span>&nbsp;<span style=\"text-decoration: underline;\">she</span>&nbsp;who called you.<br />\n" +
                "<span style=\"text-decoration: underline;\">George and I</span>&nbsp;would like to leave now.<br />\n" +
                "<span style=\"text-decoration: underline;\">We students</span>&nbsp;are going to have a party.</p>\n" +
                "</blockquote>\n" +
                "<ul>\n" +
                "    <li>Ngay sau c&aacute;c ng&ocirc;i số nhiều như we, you bạn c&oacute; thể d&ugrave;ng một danh từ số nhiều để l&agrave;m r&otilde; we, you l&agrave; chỉ c&aacute;i g&igrave;.&nbsp;<br />\n" +
                "    <span style=\"text-decoration: underline;\">We students</span>&nbsp;are going to have a party (Sinh vi&ecirc;n ch&uacute;ng t&ocirc;i .....)&nbsp;<br />\n" +
                "    <span style=\"text-decoration: underline;\">You guys</span>&nbsp;(Bọn m&agrave;y)</li>\n" +
                "    <li>\n" +
                "    <p style=\"margin-top: 12px;\">We/ You/ They c&oacute; thể d&ugrave;ng với all/ both. Trong trường hợp c&acirc;u c&oacute; động từ đơn th&igrave; ch&uacute;ng đi liền với nhau:&nbsp;<br />\n" +
                "    <span style=\"text-decoration: underline;\">We all</span>&nbsp;go to school now.&nbsp;<br />\n" +
                "    <span style=\"text-decoration: underline;\">They both</span>&nbsp;bought the ensurance&nbsp;<br />\n" +
                "    <span style=\"text-decoration: underline;\">You all</span>&nbsp;come shopping.</p>\n" +
                "    </li>\n" +
                "    <li>\n" +
                "    <p style=\"margin-top: 12px;\">Nhưng nếu&nbsp;<em>all</em>&nbsp;hoặc&nbsp;<em>both</em>&nbsp;đi với c&aacute;c đại từ n&agrave;y ở dạng c&acirc;u c&oacute; trợ động từ th&igrave;&nbsp;<em>all</em>&nbsp;hoặc&nbsp;<em>both</em>&nbsp;sẽ đứng sau trợ động từ:<br />\n" +
                "    <span style=\"text-decoration: underline;\">We will all</span>&nbsp;go to school next week.<br />\n" +
                "    <span style=\"text-decoration: underline;\">They have both</span>&nbsp;bought the insurance.</p>\n" +
                "    </li>\n" +
                "    <li>\n" +
                "    <p style=\"margin-top: 12px;\">All v&agrave; Both cũng phải đứng sau động từ&nbsp;<em>to be</em>, trước t&iacute;nh từ&nbsp;<br />\n" +
                "    <span style=\"text-decoration: underline;\">We are all</span>&nbsp;ready to go swimming.</p>\n" +
                "    </li>\n" +
                "    <li>\n" +
                "    <p style=\"margin-top: 12px;\">D&ugrave;ng&nbsp;<em>he/she</em>&nbsp;thay thế cho c&aacute;c vật nu&ocirc;i nếu ch&uacute;ng được xem l&agrave; c&oacute; t&iacute;nh c&aacute;ch, th&ocirc;ng minh hoặc t&igrave;nh cảm (ch&oacute;, m&egrave;o, ngựa...)&nbsp;<br />\n" +
                "    Go and find the cat if where&nbsp;<em>she</em>&nbsp;stays in.<br />\n" +
                "    How's your new car? Terrrific,&nbsp;<em>she</em>&nbsp;is running beautifully.</p>\n" +
                "    </li>\n" +
                "    <li>\n" +
                "    <p style=\"margin-top: 12px;\">T&ecirc;n nước, t&ecirc;n c&aacute;c con t&agrave;u được thay thế trang trọng bằng she (ng&agrave;y nay it d&ugrave;ng).&nbsp;<br />\n" +
                "    England is an island country and&nbsp;<em>she</em>&nbsp;is governed by a mornach.<br />\n" +
                "    Titanic was the biggest passenger ship ever built.&nbsp;<em>She</em>&nbsp;could carry as many as 2000 passenger on board.</p>\n" +
                "    </li>\n" +
                "</ul>\n" +
                "<h3><span style=\"color: #0070c0;\"><a name=\"5.2\">5.2</a>&nbsp;Complement pronoun (Đại từ nh&acirc;n xưng t&acirc;n ngữ)</span></h3>\n" +
                "<div style=\"text-align: center;\"><center>\n" +
                "<table border=\"1\" width=\"45%\">\n" +
                "    <tbody>\n" +
                "        <tr>\n" +
                "            <td style=\"width: 139px;\">\n" +
                "            <p style=\"text-align: center;\">me<br />\n" +
                "            you<br />\n" +
                "            him<br />\n" +
                "            her<br />\n" +
                "            it</p>\n" +
                "            </td>\n" +
                "            <td style=\"width: 139px;\">\n" +
                "            <p style=\"text-align: center;\">us<br />\n" +
                "            you<br />\n" +
                "            <br />\n" +
                "            them</p>\n" +
                "            </td>\n" +
                "        </tr>\n" +
                "    </tbody>\n" +
                "</table>\n" +
                "</center></div>\n" +
                "<p>Đại từ t&acirc;n ngữ đứng ở vị tr&iacute; t&acirc;n ngữ (đằng sau động từ hoặc giới trừ khi giới từ đ&oacute; mở đầu một mệnh đề mới). Bạn cần ph&acirc;n biệt r&otilde; đại từ t&acirc;n ngữ với đại từ chủ ngữ. Chủ ngữ l&agrave; chủ thể của h&agrave;nh động (g&acirc;y ra h&agrave;nh động), c&ograve;n t&acirc;n ngữ l&agrave; đối tượng nhận sự t&aacute;c động của h&agrave;nh động.</p>\n" +
                "<blockquote>\n" +
                "<p>They invited&nbsp;<span style=\"text-decoration: underline;\">us</span>&nbsp;to the party last night.<br />\n" +
                "The teacher gave&nbsp;<span style=\"text-decoration: underline;\">him</span>&nbsp;a bad grade.<br />\n" +
                "I told&nbsp;<span style=\"text-decoration: underline;\">her</span>&nbsp;a story.<br />\n" +
                "The policeman was looking for&nbsp;<span style=\"text-decoration: underline;\">him</span>.</p>\n" +
                "</blockquote>\n" +
                "<p>Đằng sau&nbsp;<em>us</em>&nbsp;c&oacute; thể d&ugrave;ng một danh từ số nhiều trực tiếp, giống như đối với đại từ nh&acirc;n xưng chủ ngữ.<br />\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; The teacher has made a lot of questions for&nbsp;<span style=\"text-decoration: underline;\">us students</span>.</p>\n" +
                "<h3><span style=\"color: #0070c0;\"><a name=\"5.3\">5.3</a>&nbsp;Possessive pronoun (Đại từ sở hữu)</span></h3>\n" +
                "<div style=\"text-align: center;\"><center>\n" +
                "<table border=\"1\" width=\"46%\">\n" +
                "    <tbody>\n" +
                "        <tr>\n" +
                "            <td style=\"width: 142px;\">\n" +
                "            <p style=\"text-align: center;\">mine&nbsp;<br />\n" +
                "            yours&nbsp;<br />\n" +
                "            his<br />\n" +
                "            hers&nbsp;<br />\n" +
                "            its</p>\n" +
                "            </td>\n" +
                "            <td style=\"width: 142px;\">\n" +
                "            <p style=\"text-align: center;\">ours<br />\n" +
                "            yours<br />\n" +
                "            <br />\n" +
                "            theirs</p>\n" +
                "            </td>\n" +
                "        </tr>\n" +
                "    </tbody>\n" +
                "</table>\n" +
                "</center></div>\n" +
                "<p>Người ta d&ugrave;ng đại từ sở hữu để tr&aacute;nh khỏi phải nhắc lại&nbsp;<em>t&iacute;nh từ sở hữu + danh từ</em>&nbsp;đ&atilde; đề cập trước đ&oacute;. N&oacute; c&oacute; nghĩa: mine = c&aacute;i của t&ocirc;i; yours = c&aacute;i của (c&aacute;c) bạn; ... Do đ&oacute; ch&uacute;ng thay thế cho danh từ. Đừng bao giờ d&ugrave;ng cả đại từ sở hữu lẫn danh từ. Mặc d&ugrave; c&aacute;ch viết của&nbsp;<em>his</em>&nbsp;v&agrave;&nbsp;<em>its</em>&nbsp;đối với t&iacute;nh từ sở hữu v&agrave; đại từ sở hữu l&agrave; giống nhau nhưng bạn cần ph&acirc;n biệt r&otilde; hai trường hợp n&agrave;y.</p>\n" +
                "<blockquote>\n" +
                "<p>This is my book; that is&nbsp;<span style=\"text-decoration: underline;\">yours</span>. (yours = your book)<br />\n" +
                "Your teacher is the same as&nbsp;<span style=\"text-decoration: underline;\">his</span>. (his = his teacher)<br />\n" +
                "Jill&rsquo;s dress is green and&nbsp;<span style=\"text-decoration: underline;\">mine</span>&nbsp;is red. (mine = my dress)<br />\n" +
                "Your books are heavy,&nbsp;<span style=\"text-decoration: underline;\">ours</span>&nbsp;are heavy too. (ours = our books)</p>\n" +
                "</blockquote>\n" +
                "<h4><span style=\"color: #0070c0;\"><a name=\"5.3.1\">5.3.1</a>&nbsp;Possessive adjectives (T&iacute;nh từ sở hữu)</span></h4>\n" +
                "<div style=\"text-align: center;\"><center>\n" +
                "<table border=\"1\" width=\"46%\">\n" +
                "    <tbody>\n" +
                "        <tr>\n" +
                "            <td style=\"width: 142px;\">\n" +
                "            <p style=\"text-align: center;\">my<br />\n" +
                "            your<br />\n" +
                "            his<br />\n" +
                "            her<br />\n" +
                "            its</p>\n" +
                "            </td>\n" +
                "            <td style=\"width: 142px;\">\n" +
                "            <p style=\"text-align: center;\">our<br />\n" +
                "            your<br />\n" +
                "            <br />\n" +
                "            their</p>\n" +
                "            </td>\n" +
                "        </tr>\n" +
                "    </tbody>\n" +
                "</table>\n" +
                "</center></div>\n" +
                "<p>T&iacute;nh từ sở hữu kh&aacute;c với đại từ sở hữu (n&ecirc;u tr&ecirc;n đ&acirc;y) ở chỗ n&oacute; bổ nghĩa cho danh từ chứ kh&ocirc;ng thay thế cho danh từ. Gọi l&agrave; t&iacute;nh từ sở hữu v&igrave; n&oacute; thể hiện t&iacute;nh chất sở hữu của người hoặc vật đối với danh từ đi sau n&oacute;. Ch&uacute; &yacute; rằng cũng d&ugrave;ng t&iacute;nh từ sở hữu đối với c&aacute;c bộ phận tr&ecirc;n cơ thể.</p>\n" +
                "<blockquote>\n" +
                "<p>John is eating&nbsp;<span style=\"text-decoration: underline;\">his dinner</span>.<br />\n" +
                "This is not&nbsp;<span style=\"text-decoration: underline;\">my book</span>.<br />\n" +
                "The cat has injured&nbsp;<span style=\"text-decoration: underline;\">its foot</span>.<br />\n" +
                "The boy broke&nbsp;<span style=\"text-decoration: underline;\">his arm</span>&nbsp;yesterday.<br />\n" +
                "She forgot&nbsp;<span style=\"text-decoration: underline;\">her homework</span>&nbsp;this morning.<br />\n" +
                "<span style=\"text-decoration: underline;\">My food</span>&nbsp;is cold.</p>\n" +
                "</blockquote>\n" +
                "<h3><span style=\"color: #0070c0;\"><a name=\"5.4\">5.4</a>&nbsp;Reflexive pronoun (Đại từ phản th&acirc;n)</span></h3>\n" +
                "<div style=\"text-align: center;\"><center>\n" +
                "<table border=\"1\" width=\"46%\">\n" +
                "    <tbody>\n" +
                "        <tr>\n" +
                "            <td style=\"width: 142px;\">\n" +
                "            <p style=\"text-align: center;\">myself&nbsp;<br />\n" +
                "            yourself&nbsp;<br />\n" +
                "            himself<br />\n" +
                "            herself&nbsp;<br />\n" +
                "            itself</p>\n" +
                "            </td>\n" +
                "            <td style=\"width: 142px;\">\n" +
                "            <p style=\"text-align: center;\">ourselves<br />\n" +
                "            yourselves<br />\n" +
                "            <br />\n" +
                "            themselves</p>\n" +
                "            </td>\n" +
                "        </tr>\n" +
                "    </tbody>\n" +
                "</table>\n" +
                "</center></div>\n" +
                "<ul>\n" +
                "    <li>D&ugrave;ng để diễn đạt chủ ngữ vừa l&agrave; t&aacute;c nh&acirc;n g&acirc;y ra h&agrave;nh động, vừa l&agrave; t&aacute;c nh&acirc;n nhận t&aacute;c động của h&agrave;nh động đ&oacute;. N&oacute; đứng ngay đằng sau động từ hoặc giới từ&nbsp;<em>for</em>,&nbsp;<em>to</em>&nbsp;ở cuối c&acirc;u.&nbsp;<br />\n" +
                "    &nbsp;&nbsp;&nbsp; Jill bought&nbsp;<span style=\"text-decoration: underline;\">himself</span>&nbsp;a new car.<br />\n" +
                "    Ch&uacute; &yacute;: &ldquo;Jill bought&nbsp;<span style=\"text-decoration: underline;\">him</span>&nbsp;a new car&rdquo; th&igrave; c&acirc;u c&oacute; nghĩa kh&aacute;c: &ldquo;him&rdquo; = another person.<br />\n" +
                "    &nbsp;&nbsp;&nbsp; I washed&nbsp;<span style=\"text-decoration: underline;\">myself</span><br />\n" +
                "    &nbsp;&nbsp;&nbsp; He sent the letter to&nbsp;<span style=\"text-decoration: underline;\">himself</span>.<br />\n" +
                "    &nbsp;&nbsp;&nbsp; She served&nbsp;<span style=\"text-decoration: underline;\">herself</span>&nbsp;in the cafeteria.<br />\n" +
                "    &nbsp;&nbsp;&nbsp; We hurt&nbsp;<span style=\"text-decoration: underline;\">ourselves</span>&nbsp;playing football<br />\n" +
                "    &nbsp;&nbsp;&nbsp; John and Mary hurt&nbsp;<span style=\"text-decoration: underline;\">themselves</span>&nbsp;in a car accident.<br />\n" +
                "    &nbsp;&nbsp;&nbsp; You can see the difference for&nbsp;<span style=\"text-decoration: underline;\">yourselves</span>.</li>\n" +
                "    <li>D&ugrave;ng để nhấn mạnh việc chủ ngữ tự l&agrave;m lấy việc g&igrave;, trong trường hợp n&agrave;y n&oacute; đứng ngay sau chủ ngữ hoặc sau từ&nbsp;<em>by</em>.&nbsp;<br />\n" +
                "    &nbsp;&nbsp;&nbsp; I&nbsp;<span style=\"text-decoration: underline;\">myself</span>&nbsp;believe that there is no God.<br />\n" +
                "    &nbsp;&nbsp;&nbsp; She prepared the nine-course meal by&nbsp;<span style=\"text-decoration: underline;\">herself</span>.<br />\n" +
                "    &nbsp;&nbsp;&nbsp; John washed the dishes by&nbsp;<span style=\"text-decoration: underline;\">himself</span>.<br />\n" +
                "    &nbsp;&nbsp;&nbsp; The students&nbsp;<span style=\"text-decoration: underline;\">themselves</span>&nbsp;decorated the room.<br />\n" +
                "    Ch&uacute; &yacute;: ở dạng số nhiều&nbsp;<em>self</em>&nbsp;biến th&agrave;nh&nbsp;<em>selves</em>.&nbsp;</li>\n" +
                "</ul>\n" +
                "<div><br />\n" +
                "</div>\n" +
                "\t</body>\n" +
                "</html>"));
        grammars.add(new Grammar("Tân ngữ (complement / object) và các vấn đề liên quan", "<!DOCTYPE html>\n" +
                "<html>\n" +
                "\t<head>\n" +
                "\t\t<meta charset=\"UTF-8\">\n" +
                "\t\t<title>Ngữ Pháp Tiếng Anh</title>\n" +
                "\t\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\"> \t\t\n" +
                "\t</head>\n" +
                "\t<body style=\"font-size:13px; text-align:justify\">\n" +
                "<h3><span style=\"color: #0070c0;\"><a name=\"6\">6</a>. T&acirc;n ngữ (complement / object) v&agrave; c&aacute;c vấn đề li&ecirc;n quan</span></h3>\n" +
                "<h3><span style=\"color: #0070c0;\"><a name=\"6.1\">6.1</a>&nbsp;Động từ d&ugrave;ng l&agrave;m t&acirc;n ngữ</span></h3>\n" +
                "<p>Kh&ocirc;ng phải bất cứ động từ n&agrave;o trong tiếng Anh cũng đều đ&ograve;i hỏi t&acirc;n ngữ đứng sau n&oacute; l&agrave; một danh từ. Một số c&aacute;c động từ lại đ&ograve;i hỏi t&acirc;n ngữ sau n&oacute; phải l&agrave; một động từ kh&aacute;c. Động từ d&ugrave;ng l&agrave;m t&acirc;n ngữ được chia l&agrave;m hai loại:</p>\n" +
                "<h4><span style=\"color: #0070c0;\"><a name=\"6.1.1\">6.1.1</a>. Loại 1: Động từ nguy&ecirc;n thể l&agrave;m t&acirc;n ngữ (to + verb)</span></h4>\n" +
                "<ul>\n" +
                "    <li>Bảng dưới đ&acirc;y l&agrave; những động từ đ&ograve;i hỏi t&acirc;n ngữ sau n&oacute; l&agrave; một động từ nguy&ecirc;n thể kh&aacute;c.&nbsp;</li>\n" +
                "</ul>\n" +
                "<table border=\"1\" width=\"100%\">\n" +
                "    <tbody>\n" +
                "        <tr>\n" +
                "            <td style=\"width: 124px;\">agree<br />\n" +
                "            attempt<br />\n" +
                "            claim<br />\n" +
                "            decide<br />\n" +
                "            demand</td>\n" +
                "            <td style=\"width: 124px;\">desire<br />\n" +
                "            expect<br />\n" +
                "            fail<br />\n" +
                "            forget<br />\n" +
                "            hesitate</td>\n" +
                "            <td style=\"width: 124px;\">hope<br />\n" +
                "            intend&nbsp;<br />\n" +
                "            learn<br />\n" +
                "            need<br />\n" +
                "            offer</td>\n" +
                "            <td style=\"width: 124px;\">plan<br />\n" +
                "            prepare<br />\n" +
                "            pretend<br />\n" +
                "            refuse<br />\n" +
                "            seem</td>\n" +
                "            <td valign=\"top\" style=\"width: 124px;\">strive<br />\n" +
                "            tend&nbsp;<br />\n" +
                "            want<br />\n" +
                "            wish</td>\n" +
                "        </tr>\n" +
                "    </tbody>\n" +
                "</table>\n" +
                "<blockquote>\n" +
                "<p>John&nbsp;<span style=\"text-decoration: underline;\">expects</span>&nbsp;<span style=\"text-decoration: underline;\">to begin</span>&nbsp;studying law next semester.<br />\n" +
                "Mary&nbsp;<span style=\"text-decoration: underline;\">learned</span>&nbsp;<span style=\"text-decoration: underline;\">to swim</span>&nbsp;when she was very young.<br />\n" +
                "The committee&nbsp;<span style=\"text-decoration: underline;\">decided</span>&nbsp;<span style=\"text-decoration: underline;\">to postpone</span>&nbsp;the meeting.<br />\n" +
                "The president will&nbsp;<span style=\"text-decoration: underline;\">attempt</span>&nbsp;<span style=\"text-decoration: underline;\">to reduce</span>&nbsp;inflation rate.</p>\n" +
                "</blockquote>\n" +
                "<ul>\n" +
                "    <li>Trong c&acirc;u phủ định, th&ecirc;m not v&agrave;o trước động từ l&agrave;m t&acirc;n ngữ:&nbsp;<br />\n" +
                "    John&nbsp;<span style=\"text-decoration: underline;\">decided</span>&nbsp;<span style=\"text-decoration: underline;\">not to buy</span>&nbsp;the car.</li>\n" +
                "</ul>\n" +
                "<h4><span style=\"color: #0070c0;\"><a name=\"6.1.2\">6.1.2</a>. Loại 2: Động từ Verb-ing d&ugrave;ng l&agrave;m t&acirc;n ngữ</span></h4>\n" +
                "<ul>\n" +
                "    <li>Bảng dưới đ&acirc;y l&agrave; những động từ đ&ograve;i hỏi t&acirc;n ngữ theo sau n&oacute; phải l&agrave; một Verb-ing&nbsp;</li>\n" +
                "</ul>\n" +
                "<table border=\"1\" width=\"100%\">\n" +
                "    <tbody>\n" +
                "        <tr>\n" +
                "            <td style=\"width: 209px;\">admit<br />\n" +
                "            appreciate<br />\n" +
                "            avoid<br />\n" +
                "            can't help<br />\n" +
                "            delay<br />\n" +
                "            deny<br />\n" +
                "            resist&nbsp;</td>\n" +
                "            <td style=\"width: 209px;\">enjoy<br />\n" +
                "            finish<br />\n" +
                "            miss<br />\n" +
                "            postpone<br />\n" +
                "            practice<br />\n" +
                "            quit<br />\n" +
                "            resume</td>\n" +
                "            <td style=\"width: 214px;\">suggest<br />\n" +
                "            consider<br />\n" +
                "            mind<br />\n" +
                "            recall<br />\n" +
                "            risk<br />\n" +
                "            repeat<br />\n" +
                "            resent</td>\n" +
                "        </tr>\n" +
                "    </tbody>\n" +
                "</table>\n" +
                "<blockquote>\n" +
                "<p>John&nbsp;<span style=\"text-decoration: underline;\">admitted</span>&nbsp;<span style=\"text-decoration: underline;\">stealing</span>&nbsp;the jewels.<br />\n" +
                "We&nbsp;<span style=\"text-decoration: underline;\">enjoyed</span>&nbsp;<span style=\"text-decoration: underline;\">seeing</span>&nbsp;them again after so many years.<br />\n" +
                "You shouldn&rsquo;t&nbsp;<span style=\"text-decoration: underline;\">risk</span>&nbsp;<span style=\"text-decoration: underline;\">entering</span>&nbsp;that building in its present condition.<br />\n" +
                "He was&nbsp;<span style=\"text-decoration: underline;\">considering</span>&nbsp;<span style=\"text-decoration: underline;\">buying</span>&nbsp;a new car until the prices went up.<br />\n" +
                "The Coast Guard&nbsp;<span style=\"text-decoration: underline;\">has reported</span>&nbsp;<span style=\"text-decoration: underline;\">seeing</span>&nbsp;another ship in the Florida Straits.</p>\n" +
                "</blockquote>\n" +
                "<ul>\n" +
                "    <li>Trong c&acirc;u phủ định, th&ecirc;m not v&agrave;o trước Verb-ing.&nbsp;<br />\n" +
                "    &nbsp;&nbsp;&nbsp; John&nbsp;<span style=\"text-decoration: underline;\">regretted</span>&nbsp;<span style=\"text-decoration: underline;\">not buying</span>&nbsp;the car.</li>\n" +
                "    <li>\n" +
                "    <p style=\"margin-top: 12px;\">Lưu &yacute; rằng trong bảng n&agrave;y c&oacute; mẫu động từ can't help doing/ but do smt c&oacute; nghĩa &lsquo;kh&ocirc;ng thể đừng được phải l&agrave;m g&igrave;&rsquo;&nbsp;<br />\n" +
                "    &nbsp;&nbsp;&nbsp; With such good oranges, we&nbsp;<span style=\"text-decoration: underline;\">can't help</span>&nbsp;<span style=\"text-decoration: underline;\">buying</span>&nbsp;two kilos at a time.</p>\n" +
                "    </li>\n" +
                "</ul>\n" +
                "<h4 style=\"margin-top: 12px;\"><span style=\"color: #0070c0;\"><a name=\"6.1.3\">6.1.3</a>&nbsp;Bảng dưới đ&acirc;y l&agrave; những động từ m&agrave; t&acirc;n ngữ sau n&oacute; c&oacute; thể l&agrave; một động từ nguy&ecirc;n thể hoặc một verb-ing m&agrave; ngữ nghĩa kh&ocirc;ng thay đổi.&nbsp;</span></h4>\n" +
                "<table border=\"1\" width=\"100%\">\n" +
                "    <tbody>\n" +
                "        <tr>\n" +
                "            <td style=\"width: 124px;\">begin<br />\n" +
                "            can't stand</td>\n" +
                "            <td style=\"width: 124px;\">continue<br />\n" +
                "            dread</td>\n" +
                "            <td style=\"width: 124px;\">hate<br />\n" +
                "            like&nbsp;</td>\n" +
                "            <td style=\"width: 124px;\">love&nbsp;<br />\n" +
                "            prefer</td>\n" +
                "            <td style=\"width: 124px;\">start<br />\n" +
                "            try</td>\n" +
                "        </tr>\n" +
                "    </tbody>\n" +
                "</table>\n" +
                "<p style=\"margin-top: 12px;\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; He&nbsp;<span style=\"text-decoration: underline;\">started</span>&nbsp;<span style=\"text-decoration: underline;\">to study</span>&nbsp;after dinner = he&nbsp;<span style=\"text-decoration: underline;\">started</span>&nbsp;<span style=\"text-decoration: underline;\">studying</span>&nbsp;after dinner.<br />\n" +
                "<br />\n" +
                "Lưu &yacute; rằng trong bảng n&agrave;y c&oacute; một động từ&nbsp;<em>can't stand to do/doing smt:</em>&nbsp;kh&ocirc;ng thể chịu đựng được khi phải l&agrave;m g&igrave;.&nbsp;<br />\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; He&nbsp;<span style=\"text-decoration: underline;\">can't stand</span>&nbsp;<span style=\"text-decoration: underline;\">to wait</span>&nbsp;(<span style=\"text-decoration: underline;\">waiting</span>) such a long time.</p>\n" +
                "<h4 style=\"margin-top: 12px;\"><span style=\"color: #0070c0;\"><a name=\"6.1.4\">6.1.4</a>&nbsp;Bốn động từ đặc biệt</span></h4>\n" +
                "<p style=\"margin-top: 12px;\">Đ&oacute; l&agrave; những động từ m&agrave; ngữ nghĩa của ch&uacute;ng sẽ đổi kh&aacute;c ho&agrave;n to&agrave;n khi t&acirc;n ngữ sau n&oacute; l&agrave; một động từ nguy&ecirc;n thể hoặc verb-ing.</p>\n" +
                "<p style=\"margin-top: 12px;\">1a) Stop to do smt: dừng lại để l&agrave;m g&igrave;<br />\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; He stoped to smoke = Anh ta dừng lại để h&uacute;t thuốc.<br />\n" +
                "1b) Stop doing smt: dừng l&agrave;m việc g&igrave;<br />\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; He stoped smoking = Anh ta đ&atilde; bỏ thuốc.<br />\n" +
                "2a) Remember to do smt: Nhớ sẽ phải l&agrave;m g&igrave;<br />\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Remember to send this letter. = H&atilde;y nhớ gửi bức thư n&agrave;y nh&eacute;.<br />\n" +
                "2b) Remember doing smt: Nhớ l&agrave; đ&atilde; l&agrave;m g&igrave;<br />\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; I remember locking the door before leaving, but now I can't find the key.<br />\n" +
                "Đặc biệt n&oacute; thường được d&ugrave;ng với mẫu c&acirc;u: S + still remember + V-ing : Vẫn c&ograve;n nhớ l&agrave; đ&atilde;...<br />\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; I still remember buying the first motorbike<br />\n" +
                "3a) Forget to do smt: qu&ecirc;n sẽ phải l&agrave;m g&igrave;&nbsp;<br />\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; I forgot to pickup my child after school = T&ocirc;i qu&ecirc;n kh&ocirc;ng đ&oacute;n con.<br />\n" +
                "3b) Forget doing smt: (qu&ecirc;n l&agrave; đ&atilde; l&agrave;m g&igrave;). Đặc biệt n&oacute; thường được d&ugrave;ng với mẫu c&acirc;u S + will never forget + V-ing: sẽ kh&ocirc;ng bao giờ qu&ecirc;n được l&agrave; đ&atilde; ...<br />\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; She will never forget meeting the Queen = C&ocirc; ấy kh&ocirc;ng bao giờ qu&ecirc;n lần gặp Nữ ho&agrave;ng<br />\n" +
                "4a) Regret to do smt: Lấy l&agrave;m tiếc v&igrave; phải l&agrave;m g&igrave; (thường d&ugrave;ng khi b&aacute;o tin xấu)<br />\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; We regret to inform the passengers that the flight for Washington DC was canceled because of the bad weather.<br />\n" +
                "4b) Regret doing smt: Lấy l&agrave;m tiếc v&igrave; đ&atilde; l&agrave;m g&igrave;<br />\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; He regrets leaving school early. It's the biggest mistake in his life.</p>\n" +
                "<h4 style=\"margin-top: 12px;\"><span style=\"color: #0070c0;\"><a name=\"6.1.5\">6.1.5</a>&nbsp;Động từ đứng sau giới từ</span></h4>\n" +
                "<p style=\"margin-top: 12px;\">Tất cả c&aacute;c động từ đứng ngay sau giới từ đều phải ở dạng V-ing.</p>\n" +
                "<h5 style=\"margin-top: 12px;\"><span style=\"color: #0070c0;\"><a name=\"6.1.5.1\">6.1.5.1</a>&nbsp;Verb + preposition + verb-ing</span></h5>\n" +
                "<p style=\"margin-top: 12px;\">Sau đ&acirc;y l&agrave; bảng c&aacute;c động từ c&oacute; giới từ theo sau, v&igrave; vậy c&aacute;c động từ kh&aacute;c đi sau động từ n&agrave;y phải d&ugrave;ng ở dạng verb-ing.</p>\n" +
                "<table border=\"1\" width=\"100%\">\n" +
                "    <tbody>\n" +
                "        <tr>\n" +
                "            <td colspan=\"4\" style=\"width: 644px;\">\n" +
                "            <p style=\"text-align: center;\"><strong>Verb + prepositions + V-ing</strong></p>\n" +
                "            </td>\n" +
                "        </tr>\n" +
                "        <tr>\n" +
                "            <td style=\"width: 157px;\">approve of<br />\n" +
                "            be better of<br />\n" +
                "            count on<br />\n" +
                "            depend on</td>\n" +
                "            <td style=\"width: 157px;\">give up&nbsp;<br />\n" +
                "            insist on<br />\n" +
                "            keep on<br />\n" +
                "            put off</td>\n" +
                "            <td style=\"width: 156px;\">rely on<br />\n" +
                "            succeed in<br />\n" +
                "            think about<br />\n" +
                "            think of</td>\n" +
                "            <td style=\"width: 156px;\">worry abount<br />\n" +
                "            object to<br />\n" +
                "            look forward to<br />\n" +
                "            confess to</td>\n" +
                "        </tr>\n" +
                "    </tbody>\n" +
                "</table>\n" +
                "<blockquote>\n" +
                "<p style=\"margin-top: 12px;\">John&nbsp;<span style=\"text-decoration: underline;\">gave up</span>&nbsp;<span style=\"text-decoration: underline;\">smoking</span>&nbsp;because of his doctor&rsquo;s advice.<br />\n" +
                "He&nbsp;<span style=\"text-decoration: underline;\">insisted on</span>&nbsp;<span style=\"text-decoration: underline;\">taking</span>&nbsp;the bus instead of the plane.<br />\n" +
                "Hery is&nbsp;<span style=\"text-decoration: underline;\">thinking of</span>&nbsp;<span style=\"text-decoration: underline;\">going</span>&nbsp;to France next year.<br />\n" +
                "Fred&nbsp;<span style=\"text-decoration: underline;\">confessed to</span>&nbsp;<span style=\"text-decoration: underline;\">stealing</span>&nbsp;the jewels</p>\n" +
                "</blockquote>\n" +
                "<p style=\"margin-top: 12px;\">Ch&uacute; &yacute; rằng ở 3 động từ cuối c&ugrave;ng trong bảng tr&ecirc;n, c&oacute; giới từ&nbsp;<em>to</em>&nbsp;đi sau động từ. Đ&oacute; l&agrave; giới từ chứ kh&ocirc;ng phải l&agrave;&nbsp;<em>to</em>&nbsp;trong động từ nguy&ecirc;n thể (to do st), n&ecirc;n theo sau n&oacute; phải l&agrave; một verb-ing chứ kh&ocirc;ng phải l&agrave; một verb nguy&ecirc;n thể.&nbsp;</p>\n" +
                "<blockquote>\n" +
                "<p style=\"margin-top: 12px;\">We are not&nbsp;<span style=\"text-decoration: underline;\">looking forward to</span>&nbsp;<span style=\"text-decoration: underline;\">going</span>&nbsp;back to school.<br />\n" +
                "Jill&nbsp;<span style=\"text-decoration: underline;\">objected to</span>&nbsp;<span style=\"text-decoration: underline;\">receiving</span>&nbsp;the new position.<br />\n" +
                "He&nbsp;<span style=\"text-decoration: underline;\">confessed to</span>&nbsp;<span style=\"text-decoration: underline;\">causing</span>&nbsp;the fire.</p>\n" +
                "</blockquote>\n" +
                "<h5 style=\"margin-top: 12px;\"><span style=\"color: #0070c0;\"><a name=\"6.1.5.2\">6.1.5.2</a>&nbsp;Adjective + preposition + verb-ing:</span></h5>\n" +
                "<table border=\"1\" width=\"100%\">\n" +
                "    <tbody>\n" +
                "        <tr>\n" +
                "            <td colspan=\"4\" style=\"width: 644px;\">\n" +
                "            <p style=\"text-align: center;\"><strong>Adjective + prepositions + V-ing</strong></p>\n" +
                "            </td>\n" +
                "        </tr>\n" +
                "        <tr>\n" +
                "            <td style=\"width: 157px;\">accustomed to<br />\n" +
                "            afraid of</td>\n" +
                "            <td style=\"width: 157px;\">intent on<br />\n" +
                "            interested in</td>\n" +
                "            <td style=\"width: 156px;\">capable of<br />\n" +
                "            fond of</td>\n" +
                "            <td style=\"width: 156px;\">successful in<br />\n" +
                "            tired of</td>\n" +
                "        </tr>\n" +
                "    </tbody>\n" +
                "</table>\n" +
                "<blockquote>\n" +
                "<p style=\"margin-top: 12px;\">Mitch is&nbsp;<span style=\"text-decoration: underline;\">afraid of</span>&nbsp;<span style=\"text-decoration: underline;\">getting</span>&nbsp;married now.<br />\n" +
                "We are&nbsp;<span style=\"text-decoration: underline;\">accustomed to</span>&nbsp;<span style=\"text-decoration: underline;\">sleeping</span>&nbsp;late on weekends.<br />\n" +
                "I am&nbsp;<span style=\"text-decoration: underline;\">fond of</span>&nbsp;<span style=\"text-decoration: underline;\">dancing</span>.<br />\n" +
                "We are&nbsp;<span style=\"text-decoration: underline;\">interested in</span>&nbsp;<span style=\"text-decoration: underline;\">seeing</span>&nbsp;this film.</p>\n" +
                "</blockquote>\n" +
                "<h5 style=\"margin-top: 12px;\"><span style=\"color: #0070c0;\"><a name=\"6.1.5.3\">6.1.5.3</a>&nbsp;Noun + preposition + verb-ing:</span></h5>\n" +
                "<table border=\"1\" width=\"100%\">\n" +
                "    <tbody>\n" +
                "        <tr>\n" +
                "            <td colspan=\"4\" style=\"width: 644px;\">\n" +
                "            <p style=\"text-align: center;\"><strong>Noun + prepositions + V-ing</strong></p>\n" +
                "            </td>\n" +
                "        </tr>\n" +
                "        <tr>\n" +
                "            <td style=\"width: 157px;\">choice of<br />\n" +
                "            excuse for</td>\n" +
                "            <td style=\"width: 157px;\">intention of&nbsp;<br />\n" +
                "            method for</td>\n" +
                "            <td style=\"width: 156px;\">possibility of&nbsp;<br />\n" +
                "            reason for</td>\n" +
                "            <td style=\"width: 156px;\">(method of)</td>\n" +
                "        </tr>\n" +
                "    </tbody>\n" +
                "</table>\n" +
                "<blockquote>\n" +
                "<p style=\"margin-top: 12px;\">There is no&nbsp;<span style=\"text-decoration: underline;\">reason for</span>&nbsp;<span style=\"text-decoration: underline;\">leaving</span>&nbsp;this early.<br />\n" +
                "George has no&nbsp;<span style=\"text-decoration: underline;\">excuse for</span>&nbsp;<span style=\"text-decoration: underline;\">droping</span>&nbsp;out of school.<br />\n" +
                "There is&nbsp;<span style=\"text-decoration: underline;\">a possibility of</span>&nbsp;<span style=\"text-decoration: underline;\">acquiring</span>&nbsp;this property at a good price.<br />\n" +
                "He has developed a&nbsp;<span style=\"text-decoration: underline;\">method for</span>&nbsp;<span style=\"text-decoration: underline;\">evaluating</span>&nbsp;this problem.</p>\n" +
                "</blockquote>\n" +
                "<p style=\"margin-top: 12px;\"><strong>C&aacute;c trường hợp kh&aacute;c:<br />\n" +
                "</strong>Trong c&aacute;c trường hợp kh&aacute;c, động từ đi sau giới từ cũng phải ở dạng verb-ing.<br />\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span style=\"text-decoration: underline;\">After</span>&nbsp;<span style=\"text-decoration: underline;\">leaving</span>&nbsp;the party, he drove home.<br />\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; He should have stayed in New York&nbsp;<span style=\"text-decoration: underline;\">instead of</span>&nbsp;<span style=\"text-decoration: underline;\">moving</span>&nbsp;to Maine.</p>\n" +
                "<h4 style=\"margin-top: 12px;\"><span style=\"color: #0070c0;\"><a name=\"6.1.6\">6.1.6</a>&nbsp;Động từ đi sau t&iacute;nh từ:</span></h4>\n" +
                "<p style=\"margin-top: 12px;\">N&oacute;i chung, nếu động từ&nbsp;<em>đi ngay sau t&iacute;nh từ</em>&nbsp;(kh&ocirc;ng c&oacute; giới từ) th&igrave; được d&ugrave;ng&nbsp;<em>ở dạng nguy&ecirc;n thể</em>. Những t&iacute;nh từ đ&oacute; bao gồm.</p>\n" +
                "<table border=\"1\" width=\"100%\">\n" +
                "    <tbody>\n" +
                "        <tr>\n" +
                "            <td style=\"width: 157px;\">anxious<br />\n" +
                "            boring<br />\n" +
                "            dangerous<br />\n" +
                "            hard</td>\n" +
                "            <td style=\"width: 157px;\">eager<br />\n" +
                "            easy<br />\n" +
                "            good<br />\n" +
                "            strange</td>\n" +
                "            <td style=\"width: 156px;\">pleased&nbsp;<br />\n" +
                "            prepared<br />\n" +
                "            ready<br />\n" +
                "            able</td>\n" +
                "            <td valign=\"top\" style=\"width: 156px;\">usual<br />\n" +
                "            common<br />\n" +
                "            difficult</td>\n" +
                "        </tr>\n" +
                "    </tbody>\n" +
                "</table>\n" +
                "<blockquote>\n" +
                "<p style=\"margin-top: 12px;\">It is&nbsp;<span style=\"text-decoration: underline;\">dangerous</span>&nbsp;<span style=\"text-decoration: underline;\">to drive</span>&nbsp;in this weather.<br />\n" +
                "Mike is&nbsp;<span style=\"text-decoration: underline;\">anxious</span>&nbsp;<span style=\"text-decoration: underline;\">to see</span>&nbsp;his family.<br />\n" +
                "We are&nbsp;<span style=\"text-decoration: underline;\">ready</span>&nbsp;<span style=\"text-decoration: underline;\">to leave</span>&nbsp;now.<br />\n" +
                "It is&nbsp;<span style=\"text-decoration: underline;\">difficult</span>&nbsp;<span style=\"text-decoration: underline;\">to pass</span>&nbsp;this test.</p>\n" +
                "</blockquote>\n" +
                "<p style=\"margin-top: 12px;\"><strong>Ch&uacute; &yacute;</strong>:&nbsp;<em>able</em>&nbsp;v&agrave;&nbsp;<em>capable</em>&nbsp;c&oacute; nghĩa như nhau nhưng c&aacute;ch d&ugrave;ng kh&aacute;c nhau:&nbsp;<br />\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; (able/ unable) to do smt = (capable/ incapable) of doing smt.</p>\n" +
                "<h3 style=\"margin-top: 12px;\"><span style=\"color: #0070c0;\"><a name=\"6.2\">6.2</a>&nbsp;Đại từ đứng trước động từ nguy&ecirc;n thể hoặc V-ing trong t&acirc;n ngữ</span></h3>\n" +
                "<h4 style=\"margin-top: 12px;\"><span style=\"color: #0070c0;\"><a name=\"6.2.1\">6.2.1</a>&nbsp;Trường hợp t&acirc;n ngữ l&agrave; động từ nguy&ecirc;n thể</span></h4>\n" +
                "<p style=\"margin-top: 12px;\">Trong trường hợp t&acirc;n ngữ l&agrave; động từ nguy&ecirc;n thể (loại 1) th&igrave; bất cứ danh từ hay đại từ n&agrave;o trực tiếp đứng trước n&oacute; cũng phải ở dạng t&acirc;n ngữ (complement form).&nbsp;<br />\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Joe&nbsp;<span style=\"text-decoration: underline;\">asked</span>&nbsp;<strong>her</strong>&nbsp;<span style=\"text-decoration: underline;\">to call</span>&nbsp;him.</p>\n" +
                "<div style=\"text-align: center;\"><center>\n" +
                "<table border=\"1\" width=\"60%\">\n" +
                "    <tbody>\n" +
                "        <tr>\n" +
                "            <td style=\"width: 382px;\">\n" +
                "            <p style=\"text-align: center;\">S + V + {pronoun/ noun in complement form} + [to + verb] ...</p>\n" +
                "            </td>\n" +
                "        </tr>\n" +
                "    </tbody>\n" +
                "</table>\n" +
                "</center></div>\n" +
                "<p style=\"margin-top: 12px;\">Sau đ&acirc;y l&agrave; một số động từ đ&ograve;i hỏi t&acirc;n ngữ l&agrave; một động từ nguy&ecirc;n thể c&oacute; đại từ l&agrave;m t&acirc;n ngữ gi&aacute;n tiếp.</p>\n" +
                "<table border=\"1\" width=\"100%\">\n" +
                "    <tbody>\n" +
                "        <tr>\n" +
                "            <td style=\"width: 124px;\">allow<br />\n" +
                "            ask<br />\n" +
                "            beg</td>\n" +
                "            <td style=\"width: 124px;\">convince<br />\n" +
                "            expect<br />\n" +
                "            instruct</td>\n" +
                "            <td style=\"width: 124px;\">invite<br />\n" +
                "            order<br />\n" +
                "            permit</td>\n" +
                "            <td style=\"width: 124px;\">persuade<br />\n" +
                "            prepare<br />\n" +
                "            promise</td>\n" +
                "            <td style=\"width: 124px;\">remind<br />\n" +
                "            urge<br />\n" +
                "            want</td>\n" +
                "        </tr>\n" +
                "    </tbody>\n" +
                "</table>\n" +
                "<blockquote>\n" +
                "<p style=\"margin-top: 12px;\">We&nbsp;<span style=\"text-decoration: underline;\">ordered</span>&nbsp;<strong>him</strong>&nbsp;<span style=\"text-decoration: underline;\">to appear</span>&nbsp;in court.<br />\n" +
                "I&nbsp;<span style=\"text-decoration: underline;\">urge</span>&nbsp;<strong>you</strong>&nbsp;<span style=\"text-decoration: underline;\">to reconsider</span>&nbsp;your decision.<br />\n" +
                "They were trying to&nbsp;<span style=\"text-decoration: underline;\">persuade</span>&nbsp;<strong>him</strong>&nbsp;<span style=\"text-decoration: underline;\">to change</span>&nbsp;his mind.<br />\n" +
                "The teacher&nbsp;<span style=\"text-decoration: underline;\">permitted</span>&nbsp;<strong>them</strong>&nbsp;<span style=\"text-decoration: underline;\">to turn</span>&nbsp;their assignments in late.<br />\n" +
                "You should&nbsp;<span style=\"text-decoration: underline;\">prepare</span>&nbsp;<strong>your son</strong>&nbsp;<span style=\"text-decoration: underline;\">to take</span>&nbsp;this examination.</p>\n" +
                "</blockquote>\n" +
                "<h4 style=\"margin-top: 12px;\"><span style=\"color: #0070c0;\"><a name=\"6.2.2\">6.2.2</a>&nbsp;Trường hợp t&acirc;n ngữ l&agrave; V-ing</span></h4>\n" +
                "<p style=\"margin-top: 12px;\">Trong trường hợp t&acirc;n ngữ l&agrave; một V- ing th&igrave; đại từ/danh từ phải ở dạng sở hữu.&nbsp;</p>\n" +
                "<div style=\"text-align: center;\"><center>\n" +
                "<table border=\"1\" width=\"60%\">\n" +
                "    <tbody>\n" +
                "        <tr>\n" +
                "            <td style=\"width: 382px;\">\n" +
                "            <p style=\"text-align: center;\">Subject + verb + {pronoun/ noun}(possessive form) + verb-ing...</p>\n" +
                "            </td>\n" +
                "        </tr>\n" +
                "    </tbody>\n" +
                "</table>\n" +
                "</center></div>\n" +
                "<blockquote>\n" +
                "<p style=\"margin-top: 12px;\">We&nbsp;<span style=\"text-decoration: underline;\">understand</span>&nbsp;<strong>your</strong>&nbsp;<span style=\"text-decoration: underline;\">not being</span>&nbsp;able to stay longer.<br />\n" +
                "We&nbsp;<span style=\"text-decoration: underline;\">object to</span>&nbsp;<strong>their</strong>&nbsp;<span style=\"text-decoration: underline;\">calling</span>&nbsp;at this hour.<br />\n" +
                "He&nbsp;<span style=\"text-decoration: underline;\">regrets</span>&nbsp;<strong>her</strong>&nbsp;<span style=\"text-decoration: underline;\">leaving</span>.<br />\n" +
                "We are&nbsp;<span style=\"text-decoration: underline;\">looking forward to</span>&nbsp;<strong>their</strong>&nbsp;<span style=\"text-decoration: underline;\">comming</span>&nbsp;next year.<br />\n" +
                "We don&rsquo;t&nbsp;<span style=\"text-decoration: underline;\">approve of</span>&nbsp;<strong>John&rsquo;s</strong>&nbsp;<span style=\"text-decoration: underline;\">buying</span>&nbsp;this house.<br />\n" +
                "We&nbsp;<span style=\"text-decoration: underline;\">resent</span>&nbsp;<strong>the teacher&rsquo;s</strong>&nbsp;<span style=\"text-decoration: underline;\">not announcing</span>&nbsp;the test sooner.<br />\n" +
                "<br />\n" +
                "<br />\n" +
                "</p>\n" +
                "</blockquote>\n" +
                "\t</body>\n" +
                "</html>"));
        grammars.add(new Grammar("Một số động từ đặc biệt (need, dare, to be, get)", "<!DOCTYPE html>\n" +
                "<html>\n" +
                "\t<head>\n" +
                "\t\t<meta charset=\"UTF-8\">\n" +
                "\t\t<title>Ngữ Pháp Tiếng Anh</title>\n" +
                "\t\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\"> \t\t\n" +
                "\t</head>\n" +
                "\t<body style=\"font-size:13px; text-align:justify\">\n" +
                "<h3 style=\"margin-top: 12px;\"><span style=\"color: #0070c0;\"><a name=\"7\">7</a>. Một số động từ đặc biệt (need, dare, to be, get)</span></h3>\n" +
                "<h3 style=\"margin-top: 12px;\"><span style=\"color: #0070c0;\"><a name=\"7.1\">7.1</a>&nbsp;Need</span></h3>\n" +
                "<h4 style=\"margin-top: 12px;\"><span style=\"color: #0070c0;\"><a name=\"7.1.1\">7.1.1</a>&nbsp;Need d&ugrave;ng như một động từ thường:</span></h4>\n" +
                "<p style=\"margin-top: 12px;\">a) Động từ đi sau need chỉ ở dạng nguy&ecirc;n thể khi chủ ngữ l&agrave; một&nbsp;<em>vật thể sống</em>:</p>\n" +
                "<blockquote>\n" +
                "<p style=\"margin-top: 12px;\">My friend&nbsp;<span style=\"text-decoration: underline;\">needs</span>&nbsp;<span style=\"text-decoration: underline;\">to learn</span>&nbsp;Spanish.<br />\n" +
                "He will&nbsp;<span style=\"text-decoration: underline;\">need</span>&nbsp;<span style=\"text-decoration: underline;\">to drive</span>&nbsp;alone tonight.<br />\n" +
                "John&nbsp;<span style=\"text-decoration: underline;\">needs</span>&nbsp;<span style=\"text-decoration: underline;\">to paint</span>&nbsp;his house.</p>\n" +
                "</blockquote>\n" +
                "<p style=\"margin-top: 12px;\">b) Động từ đi sau need phải ở dạng verb-ing hoặc dạng bị động nếu chủ ngữ kh&ocirc;ng phải l&agrave; vật thể sống.</p>\n" +
                "<blockquote>\n" +
                "<p style=\"margin-top: 12px;\">The grass&nbsp;<span style=\"text-decoration: underline;\">needs</span>&nbsp;<span style=\"text-decoration: underline;\">cutting</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; OR The grass needs to be cut.<br />\n" +
                "The telivision&nbsp;<span style=\"text-decoration: underline;\">needs</span>&nbsp;<span style=\"text-decoration: underline;\">repairing</span>&nbsp;&nbsp; OR The TV needs to be repaired.<br />\n" +
                "Your thesis&nbsp;<span style=\"text-decoration: underline;\">needs</span>&nbsp;<span style=\"text-decoration: underline;\">rewriting</span>&nbsp;&nbsp;&nbsp;&nbsp; OR Your thesis needs to be rewritten.</p>\n" +
                "</blockquote>\n" +
                "<p style=\"margin-top: 12px;\"><strong>Ch&uacute; &yacute;</strong>:</p>\n" +
                "<div style=\"text-align: center;\"><center>\n" +
                "<table border=\"1\" width=\"60%\">\n" +
                "    <tbody>\n" +
                "        <tr>\n" +
                "            <td style=\"width: 382px;\">\n" +
                "            <p style=\"text-align: center;\"><em>need</em>&nbsp;+ noun =&nbsp;<em>to be in need of</em>&nbsp;+ noun</p>\n" +
                "            </td>\n" +
                "        </tr>\n" +
                "    </tbody>\n" +
                "</table>\n" +
                "</center></div>\n" +
                "<blockquote>\n" +
                "<p style=\"margin-top: 12px;\">Jill&nbsp;<span style=\"text-decoration: underline;\">is</span>&nbsp;<span style=\"text-decoration: underline;\">in need of</span>&nbsp;money. = Jill needs money.<br />\n" +
                "The roof&nbsp;<span style=\"text-decoration: underline;\">is</span>&nbsp;<span style=\"text-decoration: underline;\">in need of</span>&nbsp;repair. = The roof needs repairing.</p>\n" +
                "</blockquote>\n" +
                "<p style=\"margin-top: 12px;\">Want v&agrave; Require cũng đ&ocirc;i khi được d&ugrave;ng theo mẫu c&acirc;u n&agrave;y nhưng kh&ocirc;ng phổ biến:</p>\n" +
                "<blockquote>\n" +
                "<p style=\"margin-top: 12px;\">Your hair&nbsp;<span style=\"text-decoration: underline;\">wants</span>&nbsp;<span style=\"text-decoration: underline;\">cutting</span><br />\n" +
                "All cars&nbsp;<span style=\"text-decoration: underline;\">require</span>&nbsp;<span style=\"text-decoration: underline;\">servicing</span>&nbsp;regularly</p>\n" +
                "</blockquote>\n" +
                "<h4 style=\"margin-top: 12px;\"><span style=\"color: #0070c0;\"><a name=\"7.1.2\">7.1.2</a>&nbsp;Need d&ugrave;ng như một trợ động từ</span></h4>\n" +
                "<p style=\"margin-top: 12px;\"><em>Chỉ d&ugrave;ng ở thể nghi vấn hoặc phủ định thời hiện tại</em>. Ng&ocirc;i thứ ba số &iacute;t kh&ocirc;ng c&oacute; \"s\" tận c&ugrave;ng. Kh&ocirc;ng d&ugrave;ng với trợ động từ to do. Sau need (trợ động từ) l&agrave; một động từ bỏ to:<br />\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; We&nbsp;<span style=\"text-decoration: underline;\">needn't</span>&nbsp;<span style=\"text-decoration: underline;\">reserve</span>&nbsp;seats - there will be plenty of rooms.<br />\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span style=\"text-decoration: underline;\">Need</span>&nbsp;I&nbsp;<span style=\"text-decoration: underline;\">fill</span>&nbsp;out the form?</p>\n" +
                "<ul>\n" +
                "    <li>\n" +
                "    <p style=\"margin-top: 12px;\">Thường d&ugrave;ng sau c&aacute;c từ như&nbsp;<em>if/ whether/ only/ scarcely/ hardly/ no one</em>&nbsp;<br />\n" +
                "    &nbsp;&nbsp;&nbsp; I wonder&nbsp;<span style=\"text-decoration: underline;\">if</span>&nbsp;I&nbsp;<span style=\"text-decoration: underline;\">need</span>&nbsp;fill out the form.<br />\n" +
                "    &nbsp;&nbsp;&nbsp; This is the&nbsp;<span style=\"text-decoration: underline;\">only</span>&nbsp;form you&nbsp;<span style=\"text-decoration: underline;\">need</span>&nbsp;fill out.</p>\n" +
                "    </li>\n" +
                "    <li>\n" +
                "    <p style=\"margin-top: 12px;\"><em>Needn 't + have + P2</em>&nbsp;: Lẽ ra kh&ocirc;ng cần phải&nbsp;<br />\n" +
                "    &nbsp;&nbsp;&nbsp; You needn't have come so early - only waste your time.</p>\n" +
                "    </li>\n" +
                "    <li>\n" +
                "    <p style=\"margin-top: 12px;\"><em>Needn't</em>&nbsp;= kh&ocirc;ng cần phải; trong khi&nbsp;<em>mustn't</em>&nbsp;= kh&ocirc;ng được ph&eacute;p.&nbsp;<br />\n" +
                "    &nbsp;&nbsp;&nbsp; You&nbsp;<span style=\"text-decoration: underline;\">needn&rsquo;t</span>&nbsp;apply for a visa to visit France if you hold a EU passport, but if you are not an EU citizen, you&nbsp;<span style=\"text-decoration: underline;\">mustn&rsquo;t</span>&nbsp;unless you have a visa.</p>\n" +
                "    </li>\n" +
                "</ul>\n" +
                "<h3 style=\"margin-top: 12px;\"><span style=\"color: #0070c0;\"><a name=\"7.2\">7.2</a>&nbsp;Dare (d&aacute;m)</span></h3>\n" +
                "<h4 style=\"margin-top: 12px;\"><span style=\"color: #0070c0;\"><a name=\"7.2.1\">7.2.1</a>&nbsp;D&ugrave;ng như một nội động từ</span></h4>\n" +
                "<p style=\"margin-top: 12px;\">Kh&ocirc;ng d&ugrave;ng ở thể khẳng định, chỉ d&ugrave;ng ở thể nghi vấn v&agrave; phủ định.&nbsp;<br />\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Did they dare (to) do such a thing? = Dared they do such a thing? (Họ d&aacute;m l&agrave;m như vậy sao?)<br />\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; He didn't dare (to) say anything = He dared not say anything. (Anh ta kh&ocirc;ng d&aacute;m n&oacute;i g&igrave;.)</p>\n" +
                "<ul>\n" +
                "    <li>\n" +
                "    <p style=\"margin-top: 12px;\">Dare kh&ocirc;ng được d&ugrave;ng ở thể khẳng định ngoại trừ th&agrave;nh ngữ I dare say/ I daresay với 2 nghĩa sau:&nbsp;<br />\n" +
                "    &nbsp;&nbsp;&nbsp; T&ocirc;i cho rằng: I dare say there is a restaurant at the end of the train.<br />\n" +
                "    &nbsp;&nbsp;&nbsp; T&ocirc;i thừa nhận l&agrave;: I daresay you are right.</p>\n" +
                "    </li>\n" +
                "    <li>\n" +
                "    <p style=\"margin-top: 12px;\">How dare/ dared + S + Verb in simple form: Sao ... d&aacute;m (tỏ sự giận giữ)&nbsp;<br />\n" +
                "    &nbsp;&nbsp;&nbsp; How dared you open my letter: Sao m&agrave;y d&aacute;m mở thư của tao.</p>\n" +
                "    </li>\n" +
                "</ul>\n" +
                "<h4 style=\"margin-top: 12px;\"><span style=\"color: #0070c0;\"><a name=\"7.2.2\">7.2.2</a>&nbsp;D&ugrave;ng như một ngoại động từ</span></h4>\n" +
                "<p style=\"margin-top: 12px;\">Mang nghĩa &ldquo;th&aacute;ch thức&rdquo;: Dare sb to do smt = Th&aacute;ch ai l&agrave;m g&igrave;<br />\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; They&nbsp;<span style=\"text-decoration: underline;\">dare</span>&nbsp;the boy&nbsp;<span style=\"text-decoration: underline;\">to swim</span>&nbsp;across the river in such a cold weather.<br />\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; I&nbsp;<span style=\"text-decoration: underline;\">dare</span>&nbsp;you&nbsp;<span style=\"text-decoration: underline;\">to touch</span>&nbsp;my toes = Tao th&aacute;ch m&agrave;y d&aacute;m động đến một sợi l&ocirc;ng của tao.</p>\n" +
                "<h3 style=\"margin-top: 12px;\"><span style=\"color: #0070c0;\"><a name=\"7.3\">7.3</a>&nbsp;C&aacute;ch sử dụng to be trong một số trường hợp&nbsp;</span></h3>\n" +
                "<ul>\n" +
                "    <li>\n" +
                "    <p style=\"margin-top: 12px;\">To be of + noun = to have: c&oacute; (d&ugrave;ng để chỉ t&iacute;nh chất hoặc t&igrave;nh cảm)&nbsp;<br />\n" +
                "    Mary&nbsp;<span style=\"text-decoration: underline;\">is of a gentle nature</span>&nbsp;= Mary c&oacute; một bản chất tử tế.</p>\n" +
                "    </li>\n" +
                "    <li>\n" +
                "    <p style=\"margin-top: 12px;\">To be of + noun: Nhấn mạnh cho danh từ đứng đằng sau&nbsp;<br />\n" +
                "    The newly-opened restaurant&nbsp;<span style=\"text-decoration: underline;\">is of</span>&nbsp;(ở ngay) the Leceister Square.</p>\n" +
                "    </li>\n" +
                "    <li>\n" +
                "    <p style=\"margin-top: 12px;\">To be + to + verb: l&agrave; dạng cấu tạo đặc biệt, sử dụng trong trường hợp:&nbsp;<br />\n" +
                "    - Để truyền đạt c&aacute;c mệnh lệnh hoặc c&aacute;c chỉ dẫn từ ng&ocirc;i thứ nhất qua ng&ocirc;i thứ hai đến ng&ocirc;i thứ ba.<br />\n" +
                "    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; No one&nbsp;<span style=\"text-decoration: underline;\">is</span>&nbsp;<span style=\"text-decoration: underline;\">to leave</span>&nbsp;this building without the permission of the police.<br />\n" +
                "    - D&ugrave;ng với mệnh đề&nbsp;<em>if</em>&nbsp;khi mệnh đề ch&iacute;nh diễn đạt một c&acirc;u điều kiện: Một điều phải xảy ra trước nếu muốn một điều kh&aacute;c xảy ra. (Nếu muốn... th&igrave; phải..)<br />\n" +
                "    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; If we&nbsp;<span style=\"text-decoration: underline;\">are to get</span>&nbsp;there by lunch time we had better hurry.<br />\n" +
                "    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Something must be done quickly if the endangered birds&nbsp;<span style=\"text-decoration: underline;\">are to be saved</span>.<br />\n" +
                "    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; He knew he would have to work hard if he&nbsp;<span style=\"text-decoration: underline;\">was to pass</span>&nbsp;his exam<br />\n" +
                "    - Được d&ugrave;ng để th&ocirc;ng b&aacute;o những y&ecirc;u cầu xin chỉ dẫn:<br />\n" +
                "    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; He asked the air traffic control where he&nbsp;<span style=\"text-decoration: underline;\">was to land</span>.<br />\n" +
                "    - Được d&ugrave;ng kh&aacute; phổ biến để truyền đạt một dự định, một sự sắp đặt, đặc biệt khi n&oacute; l&agrave; ch&iacute;nh thức.<br />\n" +
                "    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; She&nbsp;<span style=\"text-decoration: underline;\">is to get married</span>&nbsp;next month.<br />\n" +
                "    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; The expedition&nbsp;<span style=\"text-decoration: underline;\">is to start</span>&nbsp;in a week.<br />\n" +
                "    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; We&nbsp;<span style=\"text-decoration: underline;\">are to get</span>&nbsp;a ten percent wage rise in June.<br />\n" +
                "    - Cấu tr&uacute;c n&agrave;y th&ocirc;ng dụng tr&ecirc;n b&aacute;o ch&iacute;, khi l&agrave; tựa đề b&aacute;o th&igrave; to be được bỏ đi.<br />\n" +
                "    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; The Primer Minister (<span style=\"text-decoration: line-through;\">is</span>)&nbsp;<span style=\"text-decoration: underline;\">to make</span>&nbsp;a statement tomorrow.</p>\n" +
                "    </li>\n" +
                "    <li>\n" +
                "    <p style=\"margin-top: 12px;\">were + S + to + verb = if + S + were + to + verb = thế nếu (một giả thuyết)&nbsp;<br />\n" +
                "    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span style=\"text-decoration: underline;\">Were</span>&nbsp;<span style=\"text-decoration: underline;\">I</span>&nbsp;<span style=\"text-decoration: underline;\">to tell</span>&nbsp;you that he passed his exams, would you believe me.</p>\n" +
                "    </li>\n" +
                "    <li>\n" +
                "    <p style=\"margin-top: 12px;\">was/ were + to + verb: Để diễn đạt &yacute; tưởng về một số mệnh đ&atilde; định sẵn&nbsp;<br />\n" +
                "    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; They said goodbye without knowing that they&nbsp;<span style=\"text-decoration: underline;\">were</span>&nbsp;<span style=\"text-decoration: underline;\">never to meet</span>&nbsp;again.<br />\n" +
                "    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Since 1840, American Presidents elected in years ending in zero&nbsp;<span style=\"text-decoration: underline;\">were</span>&nbsp;<span style=\"text-decoration: underline;\">to be died</span>&nbsp;(have been destined to die) in office.</p>\n" +
                "    </li>\n" +
                "    <li>\n" +
                "    <p style=\"margin-top: 12px;\">to be about to + verb = near future (sắp sửa)&nbsp;<br />\n" +
                "    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; They&nbsp;<span style=\"text-decoration: underline;\">are</span>&nbsp;<span style=\"text-decoration: underline;\">about to leave</span>.</p>\n" +
                "    </li>\n" +
                "    <li>\n" +
                "    <p style=\"margin-top: 12px;\">Be + adj ... (mở đầu cho một ngữ) = tỏ ra...&nbsp;<br />\n" +
                "    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span style=\"text-decoration: underline;\">Be careless</span>&nbsp;in a national park where there are bears around and the result are likely to be tragical indeed.</p>\n" +
                "    </li>\n" +
                "    <li>\n" +
                "    <p style=\"margin-top: 12px;\">Be + subject + noun/ noun phrase/ adjective = cho d&ugrave; l&agrave; ...&nbsp;<br />\n" +
                "    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Societies have found various methods to support and train their artists,&nbsp;<span style=\"text-decoration: underline;\">be it</span>&nbsp;the Renaissance system of royal support of the sculptors and painters of the period or the Japanese tradition of passing artistic knowledge from father to son. (Ở c&aacute;c x&atilde; hội đều t&igrave;m thấy một số phương ph&aacute;p hỗ trợ v&agrave; đ&agrave;o tạo c&aacute;c nghệ sỹ, cho d&ugrave; l&agrave; hệ thống hỗ trợ c&aacute;c nh&agrave; đi&ecirc;u khắc v&agrave; hoạ sỹ của c&aacute;c ho&agrave;ng gia thời kỳ Phục hưng hay phương ph&aacute;p truyền thụ hiểu biết nghệ thuật từ cha sang con theo truyền thống Nhật Bản)<br />\n" +
                "    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; To have technique is to possess the physical expertise to perform whatever steps a given work may contain,&nbsp;<span style=\"text-decoration: underline;\">be</span>&nbsp;<span style=\"text-decoration: underline;\">they</span>&nbsp;<span style=\"text-decoration: underline;\">simple</span>&nbsp;or&nbsp;<span style=\"text-decoration: underline;\">complex</span>. (C&oacute; được kỹ thuật l&agrave; sẽ c&oacute; được sự đi&ecirc;u luyện để thực hiện bất kỳ thao t&aacute;c n&agrave;o m&agrave; một c&ocirc;ng việc đ&ograve;i hỏi, cho d&ugrave; l&agrave; ch&uacute;ng đơn giản hay phức tạp)</p>\n" +
                "    </li>\n" +
                "</ul>\n" +
                "<h3 style=\"margin-top: 12px;\"><span style=\"color: #0070c0;\"><a name=\"7.4\">7.4</a>&nbsp;C&aacute;ch sử dụng to get trong một số trường hợp:</span></h3>\n" +
                "<h4 style=\"margin-top: 12px;\"><span style=\"color: #0070c0;\"><a name=\"7.4.1\">7.4.1</a>. To get + P2</span></h4>\n" +
                "<p style=\"margin-top: 12px;\"><em>get washed/ dressed/ prepared/ lost/ drowned/ engaged/ married/ divorced.</em><br />\n" +
                "Chỉ việc chủ ngữ tự l&agrave;m lấy một việc g&igrave; hoặc t&igrave;nh huống m&agrave; chủ ngữ đang gặp phải.<br />\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; You will have 5 minutes to&nbsp;<span style=\"text-decoration: underline;\">get dressed</span>.(Em c&oacute; 5 ph&uacute;t để mặc quần &aacute;o)<br />\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; He&nbsp;<span style=\"text-decoration: underline;\">got lost</span>&nbsp;in old Market Street yesterday. (t&igrave;nh huống bị lạc đường)<br />\n" +
                "Tuyệt nhi&ecirc;n kh&ocirc;ng được lẫn trường hợp n&agrave;y với dạng bị động.</p>\n" +
                "<h4 style=\"margin-top: 12px;\"><span style=\"color: #0070c0;\"><a name=\"7.4.2\">7.4.2</a>. Get + V-ing = Start + V-ing: Bắt đầu l&agrave;m g&igrave;</span></h4>\n" +
                "<p style=\"margin-top: 12px;\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; We'd better&nbsp;<span style=\"text-decoration: underline;\">get moving</span>, it's late.</p>\n" +
                "<h4 style=\"margin-top: 12px;\"><span style=\"color: #0070c0;\"><a name=\"7.4.3\">7.4.3</a>. Get sb/smt +V-ing: L&agrave;m cho ai/ c&aacute;i g&igrave; bắt đầu.</span></h4>\n" +
                "<blockquote>\n" +
                "<p style=\"margin-top: 12px;\">Please&nbsp;<span style=\"text-decoration: underline;\">get him talking</span>&nbsp;about the main task. (L&agrave;m ơn bảo anh ta h&atilde;y bắt đầu đi v&agrave;o vấn đề ch&iacute;nh)&nbsp;<br />\n" +
                "When we&nbsp;<span style=\"text-decoration: underline;\">get the heater running</span>, the whole car will start to warm up. (Khi ch&uacute;ng ta cho m&aacute;y sưởi bắt đầu chạy..)</p>\n" +
                "</blockquote>\n" +
                "<h4 style=\"margin-top: 12px;\"><span style=\"color: #0070c0;\"><a name=\"7.4.4\">7.4.4</a>. Get + to + verb</span></h4>\n" +
                "<p style=\"margin-top: 12px;\">- T&igrave;m được c&aacute;ch.&nbsp;<br />\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; We could&nbsp;<span style=\"text-decoration: underline;\">get to enter</span>&nbsp;the stadium without tickets.(Ch&uacute;ng t&ocirc;i đ&atilde; t&igrave;m được c&aacute;ch lọt v&agrave;o...)<br />\n" +
                "- C&oacute; cơ may&nbsp;<br />\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; When do I&nbsp;<span style=\"text-decoration: underline;\">get to have</span>&nbsp;a promotion? (Khi n&agrave;o t&ocirc;i c&oacute; cơ may được tăng lương đ&acirc;y?)<br />\n" +
                "- Được ph&eacute;p&nbsp;<br />\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; At last we&nbsp;<span style=\"text-decoration: underline;\">got to meet</span>&nbsp;the general director. (Cuối c&ugrave;ng th&igrave; rồi ch&uacute;ng t&ocirc;i cũng được ph&eacute;p gặp tổng đạo diễn)</p>\n" +
                "<h4 style=\"margin-top: 12px;\"><span style=\"color: #0070c0;\"><a name=\"7.4.5\">7.4.5</a>. Get + to + Verb (về h&agrave;nh động) = Come + to + Verb (về nhận thức) = Gradually = dần dần</span></h4>\n" +
                "<blockquote>\n" +
                "<p style=\"margin-top: 12px;\">We will&nbsp;<span style=\"text-decoration: underline;\">get to speak</span>&nbsp;English more easily as time goes by.<br />\n" +
                "He&nbsp;<span style=\"text-decoration: underline;\">comes to understand</span>&nbsp;that learning English is not much difficult.<br />\n" +
                "<br />\n" +
                "<br />\n" +
                "</p>\n" +
                "</blockquote>\n" +
                "\n" +
                "\t</body>\n" +
                "</html>"));
        grammars.add(new Grammar("Câu hỏi", "<!DOCTYPE html>\n" +
                "<html>\n" +
                "\t<head>\n" +
                "\t\t<meta charset=\"UTF-8\">\n" +
                "\t\t<title>Ngữ Pháp Tiếng Anh</title>\n" +
                "\t\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\"> \t\t\n" +
                "\t</head>\n" +
                "\t<body style=\"font-size:13px; text-align:justify\">\n" +
                "<h3 style=\"margin-top: 12px;\"><span style=\"color: #0070c0;\"><a name=\"8\">8</a>. C&acirc;u hỏi</span></h3>\n" +
                "<p style=\"margin-top: 12px;\">Tiếng Anh c&oacute; nhiều loại c&acirc;u hỏi c&oacute; những chức năng v&agrave; mục đ&iacute;ch kh&aacute;c nhau. Trong c&acirc;u hỏi, trợ động từ hoặc động từ&nbsp;<em>be</em>&nbsp;bao giờ cũng đứng trước chủ ngữ. Nếu kh&ocirc;ng c&oacute; trợ động từ hoặc động từ&nbsp;<em>be</em>, ta phải d&ugrave;ng dạng thức&nbsp;<em>do</em>,&nbsp;<em>does</em>,&nbsp;<em>did</em>&nbsp;như một trợ động từ để thay thế. Sau c&aacute;c động từ hoặc trợ động từ đ&oacute;, phải d&ugrave;ng động ch&iacute;nh từ ở dạng nguy&ecirc;n thể kh&ocirc;ng c&oacute;&nbsp;<em>to</em>. Thời v&agrave; thể của c&acirc;u hỏi chỉ được chia bởi trợ động từ, chứ kh&ocirc;ng phải động từ ch&iacute;nh.</p>\n" +
                "<h3 style=\"margin-top: 12px;\"><span style=\"color: #0070c0;\"><a name=\"8.1\">8.1</a>&nbsp;C&acirc;u hỏi Yes/ No</span></h3>\n" +
                "<p style=\"margin-top: 12px; text-align: center;\"><strong><span style=\"color: #c00000;\">{auxiliary/ be/ do, does,did} + S + V ...</span></strong></p>\n" +
                "<p style=\"margin-top: 12px;\">Sở dĩ ta gọi l&agrave; như vậy v&igrave; khi trả lời, d&ugrave;ng&nbsp;<em>Yes/No</em>. Nhớ rằng khi trả lời:<br />\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; - Yes + Positive verb<br />\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; - No + Negative verb.<br />\n" +
                "(kh&ocirc;ng được trả lời theo kiểu c&acirc;u tiếng Việt)</p>\n" +
                "<blockquote>\n" +
                "<p style=\"margin-top: 12px;\"><span style=\"text-decoration: underline;\">Isn't</span>&nbsp;Mary&nbsp;<span style=\"text-decoration: underline;\">going</span>&nbsp;to school today?<br />\n" +
                "<span style=\"text-decoration: underline;\">Was</span>&nbsp;Mark&nbsp;<span style=\"text-decoration: underline;\">sick</span>&nbsp;yesterday?<br />\n" +
                "<span style=\"text-decoration: underline;\">Have</span>&nbsp;you&nbsp;<span style=\"text-decoration: underline;\">seen</span>&nbsp;this movie before?<br />\n" +
                "<span style=\"text-decoration: underline;\">Will</span>&nbsp;the committe&nbsp;<span style=\"text-decoration: underline;\">decide</span>&nbsp;on the proposal today?<br />\n" +
                "<span style=\"text-decoration: underline;\">Don't</span>&nbsp;you still&nbsp;<span style=\"text-decoration: underline;\">want</span>&nbsp;to use the telephone?<br />\n" +
                "<span style=\"text-decoration: underline;\">Did</span>&nbsp;you&nbsp;<span style=\"text-decoration: underline;\">go</span>&nbsp;to class yesterday?<br />\n" +
                "<span style=\"text-decoration: underline;\">Doesn't</span>&nbsp;Ted&nbsp;<span style=\"text-decoration: underline;\">like</span>&nbsp;this picture?</p>\n" +
                "</blockquote>\n" +
                "<h3 style=\"margin-top: 12px;\"><span style=\"color: #0070c0;\"><a name=\"8.2\">8.2</a>&nbsp;C&acirc;u hỏi lấy th&ocirc;ng tin (information question)</span></h3>\n" +
                "<p style=\"margin-top: 12px;\">Đối với loại c&acirc;u hỏi n&agrave;y, c&acirc;u trả lời kh&ocirc;ng thể đơn giản l&agrave; yes hay no m&agrave; phải c&oacute; th&ecirc;m th&ocirc;ng tin. Ch&uacute;ng thường d&ugrave;ng c&aacute;c từ nghi vấn, chia l&agrave;m 3 loại sau:</p>\n" +
                "<h4 style=\"margin-top: 12px;\"><span style=\"color: #0070c0;\"><a name=\"8.2.1\">8.2.1</a>&nbsp;Who hoặc What: c&acirc;u hỏi chủ ngữ</span></h4>\n" +
                "<p style=\"margin-top: 12px;\">Đ&acirc;y l&agrave; c&acirc;u hỏi khi muốn biết chủ ngữ hay chủ thể của h&agrave;nh động.</p>\n" +
                "<p style=\"margin-top: 12px; text-align: center;\"><strong><span style=\"color: #c00000;\">{who/what} + verb + (complement) + (modifier)</span></strong></p>\n" +
                "<blockquote>\n" +
                "<p style=\"margin-top: 12px;\"><span style=\"text-decoration: underline;\">Something</span>&nbsp;happened lastnight =&gt;&nbsp;<span style=\"text-decoration: underline;\">What</span>&nbsp;happened last night?<br />\n" +
                "<span style=\"text-decoration: underline;\">Someone</span>&nbsp;opened the door. =&gt;&nbsp;<span style=\"text-decoration: underline;\">Who</span>&nbsp;opened the door?</p>\n" +
                "</blockquote>\n" +
                "<p style=\"margin-top: 12px;\">Ch&uacute; &yacute; c&aacute;c c&acirc;u sau đ&acirc;y l&agrave; sai ngữ ph&aacute;p:<br />\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span style=\"text-decoration: underline;\">Who did open</span>&nbsp;the door? (SAI)<br />\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span style=\"text-decoration: underline;\">What did happen</span>&nbsp;lastnight? (SAI)</p>\n" +
                "<h4 style=\"margin-top: 12px;\"><span style=\"color: #0070c0;\"><a name=\"8.2.2\">8.2.2</a>&nbsp;Whom hoặc What: c&acirc;u hỏi t&acirc;n ngữ</span></h4>\n" +
                "<p style=\"margin-top: 12px;\">Đ&acirc;y l&agrave; c&aacute;c c&acirc;u hỏi d&ugrave;ng khi muốn biết t&acirc;n ngữ hay đối tượng t&aacute;c động của h&agrave;nh động</p>\n" +
                "<p style=\"margin-top: 12px; text-align: center;\"><strong><span style=\"color: #c00000;\">{whom/what} + {auxiliary/do, does, did} + S + V + (modifier)</span></strong></p>\n" +
                "<p style=\"margin-top: 12px;\">Nhớ rằng trong tiếng Anh viết ch&iacute;nh tắc bắt buộc phải d&ugrave;ng&nbsp;<em>whom</em>&nbsp;mặc d&ugrave; trong tiếng Anh n&oacute;i c&oacute; thể d&ugrave;ng<em>who</em>&nbsp;thay cho&nbsp;<em>whom</em>&nbsp;trong mẫu c&acirc;u tr&ecirc;n.<br />\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; George bought&nbsp;<span style=\"text-decoration: underline;\">something</span>&nbsp;at the store. =&gt;&nbsp;<span style=\"text-decoration: underline;\">What</span>&nbsp;did George buy at the store?<br />\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Ana knows&nbsp;<span style=\"text-decoration: underline;\">someone</span>&nbsp;from UK. =&gt;&nbsp;<span style=\"text-decoration: underline;\">Whom</span>&nbsp;does Ana know from UK?</p>\n" +
                "<h4 style=\"margin-top: 12px;\"><span style=\"color: #0070c0;\"><a name=\"8.2.3\">8.2.3</a>&nbsp;When, Where, How v&agrave; Why: C&acirc;u hỏi bổ ngữ</span></h4>\n" +
                "<p style=\"margin-top: 12px;\">D&ugrave;ng khi muốn biết nơi chốn, thời gian, l&yacute; do, c&aacute;ch thức của h&agrave;nh động.</p>\n" +
                "<p style=\"margin-top: 12px; text-align: center;\"><strong><span style=\"color: #c00000;\">{When/Where/How/Why} + {auxiliary/be/do,does,did} + S +V + complement + modifier</span></strong></p>\n" +
                "<blockquote>\n" +
                "<p style=\"margin-top: 12px;\"><span style=\"text-decoration: underline;\">How</span>&nbsp;<span style=\"text-decoration: underline;\">did</span>&nbsp;Maria&nbsp;<span style=\"text-decoration: underline;\">get</span>&nbsp;to school today?<br />\n" +
                "<span style=\"text-decoration: underline;\">When</span>&nbsp;<span style=\"text-decoration: underline;\">did</span>&nbsp;he&nbsp;<span style=\"text-decoration: underline;\">move</span>&nbsp;to London?<br />\n" +
                "<span style=\"text-decoration: underline;\">Why</span>&nbsp;<span style=\"text-decoration: underline;\">did</span>&nbsp;she&nbsp;<span style=\"text-decoration: underline;\">leave</span>&nbsp;so early?<br />\n" +
                "<span style=\"text-decoration: underline;\">Where</span>&nbsp;<span style=\"text-decoration: underline;\">has</span>&nbsp;Ted&nbsp;<span style=\"text-decoration: underline;\">gone</span>?<br />\n" +
                "<span style=\"text-decoration: underline;\">When</span>&nbsp;<span style=\"text-decoration: underline;\">will</span>&nbsp;she&nbsp;<span style=\"text-decoration: underline;\">come</span>&nbsp;back?<br />\n" +
                "Ch&uacute; &yacute; tr&aacute;nh nhầm lẫn với c&aacute;c c&acirc;u sai như v&iacute; dụ ở phần&nbsp;8.2.1</p>\n" +
                "</blockquote>\n" +
                "<h3 style=\"margin-top: 12px;\"><span style=\"color: #0070c0;\"><a name=\"8.3\">8.3</a>&nbsp;C&acirc;u hỏi phức (embedded question)</span></h3>\n" +
                "<p style=\"margin-top: 12px;\">L&agrave; c&acirc;u hoặc c&acirc;u hỏi chứa trong n&oacute; một c&acirc;u hỏi kh&aacute;c. C&acirc;u c&oacute; hai th&agrave;nh phần nối với nhau bằng một từ nghi vấn (question word). Động từ ở mệnh đề thứ hai (mệnh đề nghi vấn) phải đi sau v&agrave; chia theo chủ ngữ, kh&ocirc;ng được đảo vị tr&iacute; như ở c&acirc;u hỏi độc lập.&nbsp;</p>\n" +
                "<div style=\"text-align: center;\"><center>\n" +
                "<table border=\"1\" width=\"65%\">\n" +
                "    <tbody>\n" +
                "        <tr>\n" +
                "            <td style=\"width: 415px;\">\n" +
                "            <p style=\"text-align: center;\">S + V (phrase) +&nbsp;<em>question word</em>&nbsp;+ S + V</p>\n" +
                "            </td>\n" +
                "        </tr>\n" +
                "    </tbody>\n" +
                "</table>\n" +
                "</center></div>\n" +
                "<blockquote>\n" +
                "<p style=\"margin-top: 12px;\">The authorities can't figure out&nbsp;<span style=\"text-decoration: underline;\">why</span>&nbsp;<span style=\"text-decoration: underline;\">the plane</span>&nbsp;<span style=\"text-decoration: underline;\">landed</span>&nbsp;at the wrong airport.<br />\n" +
                "We haven&rsquo;t assertained&nbsp;<span style=\"text-decoration: underline;\">where</span>&nbsp;<span style=\"text-decoration: underline;\">the meeting</span>&nbsp;<span style=\"text-decoration: underline;\">will take</span>&nbsp;place.</p>\n" +
                "</blockquote>\n" +
                "<ul>\n" +
                "    <li>\n" +
                "    <p style=\"margin-top: 12px;\">Trong trường hợp c&acirc;u hỏi phức l&agrave; một c&acirc;u hỏi, &aacute;p dụng mẫu c&acirc;u sau:&nbsp;</p>\n" +
                "    </li>\n" +
                "</ul>\n" +
                "<div style=\"text-align: center;\"><center>\n" +
                "<table border=\"1\" width=\"65%\">\n" +
                "    <tbody>\n" +
                "        <tr>\n" +
                "            <td style=\"width: 415px;\">\n" +
                "            <p style=\"text-align: center;\">auxiliary + S + V +&nbsp;<em>question word</em>&nbsp;+ S + V</p>\n" +
                "            </td>\n" +
                "        </tr>\n" +
                "    </tbody>\n" +
                "</table>\n" +
                "</center></div>\n" +
                "<blockquote><blockquote>\n" +
                "<p style=\"margin-top: 12px;\">Do you know&nbsp;<span style=\"text-decoration: underline;\">where</span>&nbsp;<span style=\"text-decoration: underline;\">he</span>&nbsp;<span style=\"text-decoration: underline;\">went</span>?<br />\n" +
                "Could you tell me&nbsp;<span style=\"text-decoration: underline;\">what time</span>&nbsp;<span style=\"text-decoration: underline;\">it</span>&nbsp;<span style=\"text-decoration: underline;\">is</span>?</p>\n" +
                "</blockquote></blockquote>\n" +
                "<ul>\n" +
                "    <li>\n" +
                "    <p style=\"margin-top: 12px;\">Question word c&oacute; thể l&agrave; một từ, cũng c&oacute; thể l&agrave; một cụm từ như: whose + noun, how many, how much, how long, how often, what time, what kind.&nbsp;</p>\n" +
                "    </li>\n" +
                "</ul>\n" +
                "<blockquote><blockquote>\n" +
                "<p style=\"margin-top: 12px;\">I have no idea&nbsp;<span style=\"text-decoration: underline;\">how long</span>&nbsp;the interview will take.<br />\n" +
                "Do you know&nbsp;<span style=\"text-decoration: underline;\">how often</span>&nbsp;the bus run at night?<br />\n" +
                "Can you tell me&nbsp;<span style=\"text-decoration: underline;\">how far</span>&nbsp;the museum is from the store?<br />\n" +
                "I&rsquo;ll tell you&nbsp;<span style=\"text-decoration: underline;\">what kind of</span>&nbsp;ice-cream tastes best.<br />\n" +
                "The teacher asked us&nbsp;<span style=\"text-decoration: underline;\">whose book</span>&nbsp;was on his desk.</p>\n" +
                "</blockquote></blockquote>\n" +
                "<h3 style=\"margin-top: 12px;\"><span style=\"color: #0070c0;\"><a name=\"8.4\">8.4</a>&nbsp;C&acirc;u hỏi đu&ocirc;i (tag questions)</span></h3>\n" +
                "<p style=\"margin-top: 12px;\">Trong c&acirc;u hỏi đu&ocirc;i, người đặt c&acirc;u hỏi đưa ra một mệnh đề (mệnh đề ch&iacute;nh) nhưng kh&ocirc;ng ho&agrave;n to&agrave;n chắc chắn về t&iacute;nh đ&uacute;ng / sai của mệnh đề đ&oacute;, do vậy họ d&ugrave;ng c&acirc;u hỏi dạng n&agrave;y để kiểm chứng về mệnh đề đưa ra.&nbsp;</p>\n" +
                "<blockquote>\n" +
                "<p style=\"margin-top: 12px;\"><span style=\"text-decoration: underline;\">He should</span>&nbsp;stay in bed,&nbsp;<span style=\"text-decoration: underline;\">shouldn't he</span>? (Anh ấy n&ecirc;n ở y&ecirc;n tr&ecirc;n giường, c&oacute; phải kh&ocirc;ng?)<br />\n" +
                "<span style=\"text-decoration: underline;\">She has</span>&nbsp;been studying English for two years,&nbsp;<span style=\"text-decoration: underline;\">hasn't she</span>?<br />\n" +
                "<span style=\"text-decoration: underline;\">There are</span>&nbsp;only twenty-eight days in February,&nbsp;<span style=\"text-decoration: underline;\">aren&rsquo;t there</span>?<br />\n" +
                "<span style=\"text-decoration: underline;\">It&rsquo;s</span>&nbsp;raining now,&nbsp;<span style=\"text-decoration: underline;\">isn&rsquo;t it</span>? (Trời vẫn c&ograve;n mưa, phải kh&ocirc;ng?)<span style=\"text-decoration: underline;\"><br />\n" +
                "You and I talked</span>&nbsp;with the professor yesterday,&nbsp;<span style=\"text-decoration: underline;\">didn&rsquo;t we</span>?<br />\n" +
                "<span style=\"text-decoration: underline;\">You won&rsquo;t</span>&nbsp;be leaving for now,&nbsp;<span style=\"text-decoration: underline;\">will you</span>?<br />\n" +
                "<span style=\"text-decoration: underline;\">Jill and Joe haven&rsquo;t</span>&nbsp;been to VN,&nbsp;<span style=\"text-decoration: underline;\">have they</span>?</p>\n" +
                "</blockquote>\n" +
                "<p style=\"margin-top: 12px;\">C&acirc;u hỏi đu&ocirc;i chia l&agrave;m hai th&agrave;nh phần t&aacute;ch biệt nhau bởi dấu phẩy theo quy tắc sau:</p>\n" +
                "<ul>\n" +
                "    <li>\n" +
                "    <p style=\"margin-top: 12px;\">Sử dụng trợ động từ giống như ở mệnh đề ch&iacute;nh để l&agrave;m phần đu&ocirc;i c&acirc;u hỏi. Nếu kh&ocirc;ng c&oacute; trợ động từ th&igrave; d&ugrave;ng&nbsp;<em>do</em>,&nbsp;<em>does</em>,&nbsp;<em>did</em>&nbsp;để thay thế.&nbsp;</p>\n" +
                "    </li>\n" +
                "    <li>\n" +
                "    <p style=\"margin-top: 12px;\">Nếu mệnh đề ch&iacute;nh ở thể khẳng định th&igrave; phần đu&ocirc;i ở thể phủ định v&agrave; ngược lại.&nbsp;</p>\n" +
                "    </li>\n" +
                "    <li>\n" +
                "    <p style=\"margin-top: 12px;\">Thời của động từ ở đu&ocirc;i phải theo thời của động từ ở mệnh đề ch&iacute;nh.&nbsp;</p>\n" +
                "    </li>\n" +
                "    <li>\n" +
                "    <p style=\"margin-top: 12px;\">Chủ ngữ của mệnh đề ch&iacute;nh v&agrave; của phần đ&ocirc;i l&agrave; giống nhau. Đại từ ở phần đu&ocirc;i lu&ocirc;n phải để ở dạng chủ ngữ (in subject form)&nbsp;</p>\n" +
                "    </li>\n" +
                "    <li>\n" +
                "    <p style=\"margin-top: 12px;\">Phần đu&ocirc;i nếu ở dạng phủ định th&igrave; thường được r&uacute;t gọn (<em>n&rsquo;t</em>). Nếu kh&ocirc;ng r&uacute;t gọn th&igrave; phải theo thứ tự: auxiliary + subject + not? (He saw it yesterday,&nbsp;<span style=\"text-decoration: underline;\">did he not</span>?)&nbsp;</p>\n" +
                "    </li>\n" +
                "    <li>\n" +
                "    <p style=\"margin-top: 12px;\">Động từ&nbsp;<em>have</em>&nbsp;c&oacute; thể l&agrave; động từ ch&iacute;nh, cũng c&oacute; thể l&agrave; trợ động từ. Khi n&oacute; l&agrave; động từ ch&iacute;nh của mệnh đề trong tiếng Anh Mỹ th&igrave; phần đu&ocirc;i phải d&ugrave;ng trợ động từ&nbsp;<em>do, does hoặc did</em>. Tuy nhi&ecirc;n, trong tiếng Anh Anh th&igrave; bạn c&oacute; thể d&ugrave;ng ch&iacute;nh have như một trợ động từ trong trường hợp n&agrave;y. Khi bạn thi TOEFL l&agrave; kỳ thi kiểm tra tiếng Anh Mỹ, bạn phải ch&uacute; &yacute; để khỏi bị mất điểm.&nbsp;<br />\n" +
                "    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span style=\"text-decoration: underline;\">You have</span>&nbsp;two children,&nbsp;<span style=\"text-decoration: underline;\">haven&rsquo;t you</span>? (British English: OK, TOEFL: NOT)<br />\n" +
                "    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span style=\"text-decoration: underline;\">You have</span>&nbsp;two children,&nbsp;<span style=\"text-decoration: underline;\">don't you</span>? (Correct in American English)</p>\n" +
                "    </li>\n" +
                "    <li>\n" +
                "    <p style=\"margin-top: 12px;\"><em>There is</em>,&nbsp;<em>there are</em>&nbsp;v&agrave;&nbsp;<em>it is</em>&nbsp;l&agrave; c&aacute;c chủ ngữ giả n&ecirc;n phần đu&ocirc;i được ph&eacute;p d&ugrave;ng lại&nbsp;<em>there</em>&nbsp;hoặc&nbsp;<em>it</em>&nbsp;giống như trường hợp đại từ l&agrave;m chủ ngữ.&nbsp;</p>\n" +
                "    </li>\n" +
                "</ul>\n" +
                "\n" +
                "\t</body>\n" +
                "</html>"));
        grammars.add(new Grammar("Lối nói phụ họa", "<!DOCTYPE html>\n" +
                "<html>\n" +
                "\t<head>\n" +
                "\t\t<meta charset=\"UTF-8\">\n" +
                "\t\t<title>Ngữ Pháp Tiếng Anh</title>\n" +
                "\t\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\"> \t\t\n" +
                "\t</head>\n" +
                "\t<body style=\"font-size:13px; text-align:justify\">\n" +
                "<h3 style=\"margin-top: 12px;\"><span style=\"color: #0070c0;\"><a name=\"9\">9</a>. Lối n&oacute;i phụ họa</span></h3>\n" +
                "<h3 style=\"margin-top: 12px;\"><span style=\"color: #0070c0;\"><a name=\"9.1\">9.1</a>&nbsp;Phụ hoạ c&acirc;u khẳng định</span></h3>\n" +
                "<p style=\"margin-top: 12px;\">Khi muốn n&oacute;i một người hoặc vật n&agrave;o đ&oacute; l&agrave;m một việc g&igrave; đ&oacute; v&agrave; một người, vật kh&aacute;c cũng l&agrave;m một việc như vậy, người ta d&ugrave;ng&nbsp;<em>so</em>&nbsp;hoặc&nbsp;<em>too</em>. Để tr&aacute;nh phải lặp lại c&aacute;c từ của c&acirc;u trước (mệnh đề ch&iacute;nh), người ta d&ugrave;ng li&ecirc;n từ&nbsp;<em>and</em>&nbsp;v&agrave; th&ecirc;m một c&acirc;u đơn giản (mệnh đề phụ) c&oacute; sử dụng&nbsp;<em>so</em>&nbsp;hoặc&nbsp;<em>too</em>. &Yacute; nghĩa của hai từ n&agrave;y c&oacute; nghĩa l&agrave; &ldquo;cũng thế&rdquo;.&nbsp;</p>\n" +
                "<blockquote>\n" +
                "<p style=\"margin-top: 12px;\">John&nbsp;<span style=\"text-decoration: underline;\">went</span>&nbsp;to the mountains on his vacation, and&nbsp;<span style=\"text-decoration: underline;\">we did too</span>.<br />\n" +
                "John&nbsp;<span style=\"text-decoration: underline;\">went</span>&nbsp;to the mountains on his vacation, and&nbsp;<span style=\"text-decoration: underline;\">so did we</span>.<br />\n" +
                "I&nbsp;<span style=\"text-decoration: underline;\">will</span>&nbsp;be in VN in May, and&nbsp;<span style=\"text-decoration: underline;\">they will too</span>.<br />\n" +
                "I&nbsp;<span style=\"text-decoration: underline;\">will</span>&nbsp;be in VN in May, and&nbsp;<span style=\"text-decoration: underline;\">so will they</span>.<br />\n" +
                "He&nbsp;<span style=\"text-decoration: underline;\">has</span>&nbsp;seen her play, and&nbsp;<span style=\"text-decoration: underline;\">the girls have too</span>.<br />\n" +
                "He&nbsp;<span style=\"text-decoration: underline;\">has</span>&nbsp;seen her play, and&nbsp;<span style=\"text-decoration: underline;\">so have the girls</span>.<br />\n" +
                "We&nbsp;<span style=\"text-decoration: underline;\">are</span>&nbsp;going to the movie tonight, and&nbsp;<span style=\"text-decoration: underline;\">he is too</span>.<br />\n" +
                "We&nbsp;<span style=\"text-decoration: underline;\">are</span>&nbsp;going to the movie tonight, and&nbsp;<span style=\"text-decoration: underline;\">so is he</span>.<br />\n" +
                "She&nbsp;<span style=\"text-decoration: underline;\">will</span>&nbsp;wear a custome to the party, and&nbsp;<span style=\"text-decoration: underline;\">we will too</span>.<br />\n" +
                "She&nbsp;<span style=\"text-decoration: underline;\">will</span>&nbsp;wear a custome to the party, and&nbsp;<span style=\"text-decoration: underline;\">so will we</span>.<br />\n" +
                "Picaso&nbsp;<span style=\"text-decoration: underline;\">was</span>&nbsp;a famous painter, and&nbsp;<span style=\"text-decoration: underline;\">Rubens was too</span>.<br />\n" +
                "Picaso&nbsp;<span style=\"text-decoration: underline;\">was</span>&nbsp;a famous painter, and&nbsp;<span style=\"text-decoration: underline;\">so was Rubens</span>.</p>\n" +
                "</blockquote>\n" +
                "<p style=\"margin-top: 12px;\">Tuỳ theo từ n&agrave;o được d&ugrave;ng m&agrave; cấu tr&uacute;c c&acirc;u c&oacute; sự thay đổi:</p>\n" +
                "<ol>\n" +
                "    <li>\n" +
                "    <p style=\"margin-top: 12px;\">Khi trong mệnh đề ch&iacute;nh c&oacute; động từ&nbsp;<em>be</em>&nbsp;ở bất cứ thời n&agrave;o th&igrave; trong mệnh đề phụ cũng d&ugrave;ng từ&nbsp;<em>be</em>&nbsp;ở thời đ&oacute;.</p>\n" +
                "    </li>\n" +
                "</ol>\n" +
                "<p style=\"margin-top: 12px; text-align: center;\"><strong><span style=\"color: #c00000;\">affirmative statement (be) + and + {S + verb (be) + too / so + verb (be) + S}</span></strong></p>\n" +
                "<blockquote><blockquote>\n" +
                "<p style=\"margin-top: 12px;\">I&nbsp;<span style=\"text-decoration: underline;\">am</span>&nbsp;happy, and&nbsp;<span style=\"text-decoration: underline;\">you are too</span>.<br />\n" +
                "I&nbsp;<span style=\"text-decoration: underline;\">am</span>&nbsp;happy, and&nbsp;<span style=\"text-decoration: underline;\">so are you</span>.</p>\n" +
                "</blockquote></blockquote>\n" +
                "<ol start=\"2\">\n" +
                "    <li>\n" +
                "    <p style=\"margin-top: 12px;\">Khi trong mệnh đề ch&iacute;nh c&oacute; một cụm trợ động từ + động từ, v&iacute; dụ&nbsp;<em>will go, should do, has done, have written, must consider</em>, ... th&igrave; c&aacute;c trợ động từ trong mệnh đề đ&oacute; được d&ugrave;ng lại trong mệnh đề phụ.</p>\n" +
                "    </li>\n" +
                "</ol>\n" +
                "<p style=\"margin-top: 12px; text-align: center;\"><strong><span style=\"color: #c00000;\">affirmative statement (compound verb) + and + {S + (auxiliary only) + too / so + (auxiliary only)+ S}</span></strong></p>\n" +
                "<blockquote><blockquote>\n" +
                "<p style=\"margin-top: 12px;\">They&nbsp;<span style=\"text-decoration: underline;\">will</span>&nbsp;work in the lab tomorrow, and&nbsp;<span style=\"text-decoration: underline;\">you will too</span>.<br />\n" +
                "They&nbsp;<span style=\"text-decoration: underline;\">will</span>&nbsp;work in the lab tomorrow, and&nbsp;<span style=\"text-decoration: underline;\">so will you</span>.</p>\n" +
                "</blockquote></blockquote>\n" +
                "<ol start=\"3\">\n" +
                "    <li>\n" +
                "    <p style=\"margin-top: 12px;\">Khi trong mệnh đề ch&iacute;nh kh&ocirc;ng phải l&agrave; động từ&nbsp;<em>be</em>, cũng kh&ocirc;ng c&oacute; trợ động từ, bạn phải d&ugrave;ng c&aacute;c từ<em>do, does, did</em>&nbsp;l&agrave;m trợ động từ thay thế. Thời v&agrave; thể của trợ động từ n&agrave;y phải chia theo chủ ngữ của mệnh đề phụ.</p>\n" +
                "    </li>\n" +
                "</ol>\n" +
                "<p style=\"margin-top: 12px; text-align: center;\"><strong><span style=\"color: #c00000;\">affirmative statement (compound verb) + and + {S + (do, does, did) + too / so + (do, does, did)+ S}</span></strong></p>\n" +
                "<blockquote><blockquote>\n" +
                "<p style=\"margin-top: 12px;\">Jane&nbsp;<span style=\"text-decoration: underline;\">goes</span>&nbsp;to that school, and&nbsp;<span style=\"text-decoration: underline;\">my sister does too</span>.<br />\n" +
                "Jane&nbsp;<span style=\"text-decoration: underline;\">goes</span>&nbsp;to that school, and&nbsp;<em>so does my sister</em>.</p>\n" +
                "</blockquote></blockquote>\n" +
                "<h3 style=\"margin-top: 12px;\"><span style=\"color: #0070c0;\"><a name=\"9.2\">9.2</a>&nbsp;Phụ hoạ c&acirc;u phủ định</span></h3>\n" +
                "<p style=\"margin-top: 12px;\">Cũng giống như too v&agrave; so trong c&acirc;u khẳng định, để phụ hoạ một c&acirc;u phủ định, người ta d&ugrave;ng either hoặc neither. Hai từ n&agrave;y c&oacute; nghĩa &ldquo;cũng kh&ocirc;ng&rdquo;. Ba quy tắc đối với trợ động từ, động từ be hoặc do, does, did cũng được &aacute;p dụng giống như tr&ecirc;n. Ta cũng c&oacute; thể g&oacute;i gọn 3 quy tắc đ&oacute; v&agrave;o một c&ocirc;ng thức như sau:</p>\n" +
                "<p style=\"margin-top: 12px; text-align: center;\"><strong><span style=\"color: #c00000;\">negative statement + and + {S + negative auxiliary(or be) + either / neither + posotive auxiliary(or be) + S}</span></strong></p>\n" +
                "<blockquote>\n" +
                "<p style=\"margin-top: 12px;\">I&nbsp;<span style=\"text-decoration: underline;\">didn't see</span>&nbsp;Mary this morning, and&nbsp;<span style=\"text-decoration: underline;\">John didn't either</span><br />\n" +
                "I&nbsp;<span style=\"text-decoration: underline;\">didn't see</span>&nbsp;Mary this morning, and&nbsp;<span style=\"text-decoration: underline;\">neither did John</span>.<br />\n" +
                "She&nbsp;<span style=\"text-decoration: underline;\">won&rsquo;t be</span>&nbsp;going to the conference, and&nbsp;<span style=\"text-decoration: underline;\">her friends won&rsquo;t either</span>.<br />\n" +
                "She&nbsp;<span style=\"text-decoration: underline;\">won&rsquo;t be</span>&nbsp;going to the conference, and&nbsp;<span style=\"text-decoration: underline;\">neither will her friends</span>.<br />\n" +
                "John&nbsp;<span style=\"text-decoration: underline;\">hasn&rsquo;t seen</span>&nbsp;the new movie yet, and&nbsp;<span style=\"text-decoration: underline;\">I haven&rsquo;t either</span>.<br />\n" +
                "John&nbsp;<span style=\"text-decoration: underline;\">hasn&rsquo;t seen</span>&nbsp;the new movie yet,&nbsp;<span style=\"text-decoration: underline;\">and neither have I</span>.<br />\n" +
                "<br />\n" +
                "<br />\n" +
                "</p>\n" +
                "</blockquote>\n" +
                "\n" +
                "\t</body>\n" +
                "</html>"));
        grammars.add(new Grammar("Câu phủ định (negation)", "<!DOCTYPE html>\n" +
                "<html>\n" +
                "    <head>\n" +
                "        <meta charset=\"UTF-8\" />\n" +
                "        <title>Ngữ Ph&aacute;p Tiếng Anh</title>\n" +
                "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\" />\n" +
                "    </head>\n" +
                "    <body style=\"font-size:13px; text-align:justify\">\n" +
                "        <h3 style=\"margin-top: 12px;\"><span style=\"color: #0070c0;\"><a name=\"10\">10</a>. C&acirc;u phủ định (negation)</span></h3>\n" +
                "        <p style=\"margin-top: 12px;\">Để tạo c&acirc;u phủ định đặt&nbsp;<em>not</em>&nbsp;sau trợ động từ hoặc động từ&nbsp;<em>be</em>&nbsp;. Nếu kh&ocirc;ng c&oacute; trợ động từ hoặc động từ&nbsp;<em>be</em>th&igrave; d&ugrave;ng dạng thức th&iacute;ch hợp của&nbsp;<em>do, does hoặc did</em>&nbsp;để thay thế.</p>\n" +
                "        <blockquote>\n" +
                "        <p style=\"margin-top: 12px;\">John is rich =&gt; John&nbsp;<span style=\"text-decoration: underline;\">is</span>&nbsp;<span style=\"text-decoration: underline;\">not</span>&nbsp;rich.<br />\n" +
                "        Mark has seen Bill =&gt; Mark&nbsp;<span style=\"text-decoration: underline;\">has</span>&nbsp;<span style=\"text-decoration: underline;\">not</span>&nbsp;<span style=\"text-decoration: underline;\">seen</span>&nbsp;Bill<br />\n" +
                "        Mary can swim =&gt; Mary&nbsp;<span style=\"text-decoration: underline;\">cannot</span>&nbsp;swim.<br />\n" +
                "        I went to the store yesterday =&gt; I&nbsp;<span style=\"text-decoration: underline;\">did</span>&nbsp;<span style=\"text-decoration: underline;\">not</span>&nbsp;<span style=\"text-decoration: underline;\">go</span>&nbsp;to the store yesterday.<br />\n" +
                "        Mark likes spinach =&gt; Mark&nbsp;<span style=\"text-decoration: underline;\">doesn&rsquo;t</span>&nbsp;<span style=\"text-decoration: underline;\">like</span>&nbsp;spinach.<br />\n" +
                "        I want to leave now =&gt; I&nbsp;<span style=\"text-decoration: underline;\">don&rsquo;t</span>&nbsp;<span style=\"text-decoration: underline;\">want</span>&nbsp;to leave now.</p>\n" +
                "        </blockquote>\n" +
                "        <h3 style=\"margin-top: 12px;\"><span style=\"color: #0070c0;\"><a name=\"10.1\">10.1</a>&nbsp;Some/any:&nbsp;</span></h3>\n" +
                "        <p style=\"margin-top: 12px;\">Đặt&nbsp;<em>any</em>&nbsp;đằng trước danh từ l&agrave;m vị ngữ sẽ nhấn mạnh c&acirc;u phủ định. Cũng c&oacute; thể nhấn mạnh một c&acirc;u phủ định bằng c&aacute;ch d&ugrave;ng&nbsp;<em>no + danh từ</em>&nbsp;hoặc&nbsp;<em>a single + danh từ số &iacute;t</em>.&nbsp;<br />\n" +
                "        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; John has some money =&gt; John&nbsp;<span style=\"text-decoration: underline;\">doesn&rsquo;t have</span>&nbsp;<span style=\"text-decoration: underline;\">any money</span>.<br />\n" +
                "        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; He sold some magazines yesterday =&gt; He&nbsp;<span style=\"text-decoration: underline;\">didn't sell</span>&nbsp;<span style=\"text-decoration: underline;\">a single magazine</span>&nbsp;yesterday.&nbsp;<br />\n" +
                "        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; = He&nbsp;<span style=\"text-decoration: underline;\">sold</span>&nbsp;<span style=\"text-decoration: underline;\">no magazine</span>&nbsp;yesterday.</p>\n" +
                "        <h3 style=\"margin-top: 12px;\"><span style=\"color: #0070c0;\"><a name=\"10.2\">10.2</a>&nbsp;Một số c&aacute;c c&acirc;u hỏi ở dạng phủ định lại mang &yacute; nghĩa kh&aacute;c (kh&ocirc;ng d&ugrave;ng dấu ?):</span>&nbsp;</h3>\n" +
                "        <p style=\"margin-top: 12px;\">- Nhấn mạnh cho sự khẳng định của người n&oacute;i.<br />\n" +
                "        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span style=\"text-decoration: underline;\">Shouldn 't you put</span>&nbsp;on your hat, too! : Thế th&igrave; anh cũng đội lu&ocirc;n mũ v&agrave;o đi.<br />\n" +
                "        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span style=\"text-decoration: underline;\">Didn't you say</span>&nbsp;that you would come to the party tonight: Thế anh đ&atilde; chẳng n&oacute;i l&agrave; anh đi dự tiệc tối nay hay sao.<br />\n" +
                "        - D&ugrave;ng để t&aacute;n dương<br />\n" +
                "        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span style=\"text-decoration: underline;\">Wasn 't the weather wonderful</span>&nbsp;yesterday: Thời tiết h&ocirc;m qua đẹp tuyệt vời.<br />\n" +
                "        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span style=\"text-decoration: underline;\">Wouldn't it be</span>&nbsp;nice if we didn't have to work on Friday.<br />\n" +
                "        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Thật l&agrave; tuyệt vời khi ch&uacute;ng ta kh&ocirc;ng phải l&agrave;m việc ng&agrave;y thứ 6.</p>\n" +
                "        <h3 style=\"margin-top: 12px;\"><span style=\"color: #0070c0;\"><a name=\"10.3\">10.3</a>&nbsp;Hai lần phủ định</span></h3>\n" +
                "        <p style=\"margin-top: 12px;\">Negative + Negative = Positive (Mang &yacute; nghĩa nhấn mạnh)&nbsp;<br />\n" +
                "        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; It's&nbsp;<span style=\"text-decoration: underline;\">unbelieveable</span>&nbsp;he is&nbsp;<span style=\"text-decoration: underline;\">not</span>&nbsp;rich. (Chẳng ai c&oacute; thể tin được l&agrave; anh ta lại kh&ocirc;ng gi&agrave;u c&oacute;.)</p>\n" +
                "        <h3 style=\"margin-top: 12px;\"><span style=\"color: #0070c0;\"><a name=\"10.4\">10.4</a>&nbsp;Phủ định kết hợp với so s&aacute;nh</span></h3>\n" +
                "        <p style=\"margin-top: 12px;\">Negative + comparative (more/ less) = superlative&nbsp;(Mang nghĩa so s&aacute;nh tuyệt đối)<br />\n" +
                "        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; I&nbsp;<span style=\"text-decoration: underline;\">couldn't agree</span>&nbsp;with you&nbsp;<span style=\"text-decoration: underline;\">less</span>&nbsp;= I absolutely agree with you.<br />\n" +
                "        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; You&nbsp;<span style=\"text-decoration: underline;\">couldn't have gone</span>&nbsp;to the beach on a&nbsp;<span style=\"text-decoration: underline;\">better</span>&nbsp;day = It's the best day to go to the beach.<br />\n" +
                "        Nhưng phải hết sức cẩn thận v&igrave; :<br />\n" +
                "        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; He&nbsp;<span style=\"text-decoration: underline;\">couldn't have been</span>&nbsp;<span style=\"text-decoration: underline;\">more unfriendly</span>&nbsp;when I met him first. = the most unfriendly<br />\n" +
                "        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; The surgery&nbsp;<span style=\"text-decoration: underline;\">couldn't have been</span>&nbsp;<span style=\"text-decoration: underline;\">more unnecessary</span>. = absolutely unnecessary</p>\n" +
                "        <h3 style=\"margin-top: 12px;\"><span style=\"color: #0070c0;\"><a name=\"10.5\">10.5</a>&nbsp;Cấu tr&uacute;c phủ định song song</span></h3>\n" +
                "        <p style=\"margin-top: 12px;\"><em>Negative... even/still less/much less + noun/ verb in simple form</em>: kh&ocirc;ng ... m&agrave; lại c&agrave;ng kh&ocirc;ng.&nbsp;<br />\n" +
                "        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; These students&nbsp;<span style=\"text-decoration: underline;\">don't like</span>&nbsp;reading novel,&nbsp;<span style=\"text-decoration: underline;\">much less</span>&nbsp;textbook.<br />\n" +
                "        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Những sinh vi&ecirc;n n&agrave;y chẳng th&iacute;ch đọc tiểu thuyết, chứ chưa n&oacute;i đến s&aacute;ch gi&aacute;o khoa.<br />\n" +
                "        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span style=\"text-decoration: underline;\">It's unbelieveable</span>&nbsp;how he could have survived such a freefall,&nbsp;<span style=\"text-decoration: underline;\">much less</span>&nbsp;live to tell about it on television.<br />\n" +
                "        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Thật kh&ocirc;ng thể tin được anh ta lại c&oacute; thể sống s&oacute;t sau c&uacute; rơi tự do đ&oacute;, chứ đừng n&oacute;i đến chuyện l&ecirc;n TV kể về n&oacute;.</p>\n" +
                "        <h3 style=\"margin-top: 12px;\"><span style=\"color: #0070c0;\"><a name=\"10.6\">10.6</a>&nbsp;Phủ định kh&ocirc;ng d&ugrave;ng thể phủ định của động từ</span></h3>\n" +
                "        <p style=\"margin-top: 12px;\">Một số c&aacute;c ph&oacute; từ trong tiếng Anh mang nghĩa phủ định (negative adverb), khi đ&atilde; d&ugrave;ng n&oacute; th&igrave; trong c&acirc;u kh&ocirc;ng d&ugrave;ng cấu tạo phủ định của động từ nữa:&nbsp;<br />\n" +
                "        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Hardly, barely, scarcely = almost nothing/ almost not at all = hầu như kh&ocirc;ng.<br />\n" +
                "        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Hardly ever, seldom, rarely = almost never = hầu như kh&ocirc;ng bao giờ.</p>\n" +
                "        <div style=\"text-align: center;\"><center>\n" +
                "        <table border=\"1\" width=\"60%\">\n" +
                "            <tbody>\n" +
                "                <tr>\n" +
                "                    <td style=\"width: 382px;\">\n" +
                "                    <p style=\"text-align: center;\"><span style=\"color: #c00000;\"><strong>subject + negative adverb + positive verb</strong></span></p>\n" +
                "                    </td>\n" +
                "                </tr>\n" +
                "            </tbody>\n" +
                "        </table>\n" +
                "        </center></div>\n" +
                "        <p style=\"margin-top: 12px;\">&nbsp;</p>\n" +
                "        <div style=\"text-align: center;\"><center>\n" +
                "        <table border=\"1\" width=\"60%\">\n" +
                "            <tbody>\n" +
                "                <tr>\n" +
                "                    <td style=\"width: 382px;\">\n" +
                "                    <p style=\"text-align: center;\"><span style=\"color: #c00000;\"><strong>subject + to be + negative adverb</strong></span></p>\n" +
                "                    </td>\n" +
                "                </tr>\n" +
                "            </tbody>\n" +
                "        </table>\n" +
                "        </center></div>\n" +
                "        <blockquote><blockquote>\n" +
                "        <p style=\"margin-top: 12px;\">John&nbsp;<span style=\"text-decoration: underline;\">rarely</span>&nbsp;comes to class on time. (John chẳng mấy khi đến lớp đ&uacute;ng giờ)<br />\n" +
                "        Tom&nbsp;<span style=\"text-decoration: underline;\">hardly</span>&nbsp;studied lastnight. (T&ocirc;m chẳng học g&igrave; tối qua)<br />\n" +
                "        She&nbsp;<span style=\"text-decoration: underline;\">scarcely</span>&nbsp;remembers the accident. (C&ocirc; ấy kh&oacute; m&agrave; nhớ được vụ tai nạn)<br />\n" +
                "        We&nbsp;<span style=\"text-decoration: underline;\">seldom</span>&nbsp;see photos of these animals. (Ch&uacute;ng t&ocirc;i hiếm khi thấy ảnh của những động vật n&agrave;y)</p>\n" +
                "        </blockquote>\n" +
                "        <p style=\"margin-top: 12px;\">*Lưu &yacute; rằng c&aacute;c ph&oacute; từ n&agrave;y kh&ocirc;ng mang nghĩa phủ định ho&agrave;n to&agrave;n m&agrave; mang nghĩa gần như phủ định. Đặc biệt l&agrave; những từ như&nbsp;<em>barely</em>&nbsp;v&agrave;&nbsp;<em>scarcely</em>&nbsp;khi đi với những từ như&nbsp;<em>enough</em>&nbsp;v&agrave;&nbsp;<em>only</em>hoặc những th&agrave;nh ngữ chỉ sự ch&iacute;nh x&aacute;c.<br />\n" +
                "        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; - Do you have enough money for the tution fee?&nbsp;<br />\n" +
                "        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; -&nbsp;<span style=\"text-decoration: underline;\">Only barely</span>. Vừa đủ.</p>\n" +
                "        </blockquote>\n" +
                "        <h3 style=\"margin-top: 12px;\"><span style=\"color: #0070c0;\"><a name=\"10.7\">10.7</a>&nbsp;Thể phủ định của một số động từ đặc biệt</span></h3>\n" +
                "        <p style=\"margin-top: 12px;\">Đối với những động từ như&nbsp;<em>to think, to believe, to suppose, to imagine</em>&nbsp;+&nbsp;<em>that</em>&nbsp;+&nbsp;<em>sentense</em>. Khi chuyển sang c&acirc;u phủ định, phải cấu tạo phủ định ở c&aacute;c động từ đ&oacute;, kh&ocirc;ng được cấu tạo phủ định ở mệnh đề thứ hai.&nbsp;<br />\n" +
                "        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; I&nbsp;<span style=\"text-decoration: underline;\">don't think</span>&nbsp;you came to class yesterday. (Kh&ocirc;ng d&ugrave;ng: I think you&nbsp;<span style=\"text-decoration: underline;\">didn't come</span>&nbsp;to class yesterday)<br />\n" +
                "        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; I&nbsp;<span style=\"text-decoration: underline;\">don't believe</span>&nbsp;she stays at home now.</p>\n" +
                "        <h3 style=\"margin-top: 12px;\"><span style=\"color: #0070c0;\"><a name=\"10.8\">10.8</a>&nbsp;No matter</span></h3>\n" +
                "        <p style=\"margin-top: 12px;\"><strong>No matter +&nbsp;</strong><em>who/what/which/where/when/how</em>&nbsp;+ Subject + verb in present: D&ugrave; c&oacute;... đi chăng nữa... th&igrave;&nbsp;<br />\n" +
                "        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span style=\"text-decoration: underline;\">No matter who</span>&nbsp;telephones, say I&rsquo;m out.&nbsp;<br />\n" +
                "        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Cho d&ugrave; l&agrave; ai gọi đến th&igrave; h&atilde;y bảo l&agrave; t&ocirc;i đi vắng.<br />\n" +
                "        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span style=\"text-decoration: underline;\">No matter where</span>&nbsp;you go, you will find Coca-Cola.&nbsp;<br />\n" +
                "        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Cho d&ugrave; anh c&oacute; đi đến đ&acirc;u, anh cũng sẽ thấy nh&atilde;n hiệu Coca-Cola<br />\n" +
                "        No matter who = whoever; No matter what = whatever<br />\n" +
                "        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span style=\"text-decoration: underline;\">No matter what</span>&nbsp;(whatever) you say, I won&rsquo;t believe you.&nbsp;<br />\n" +
                "        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Cho d&ugrave; anh c&oacute; n&oacute;i g&igrave; đi chăng nữa, t&ocirc;i cũng kh&ocirc;ng tin anh.<br />\n" +
                "        C&aacute;c cấu tr&uacute;c n&agrave;y c&oacute; thể đứng cuối c&acirc;u m&agrave; kh&ocirc;ng cần c&oacute; mệnh đề theo sau:<br />\n" +
                "        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; I will always love you,&nbsp;<span style=\"text-decoration: underline;\">no matter what</span>.</p>\n" +
                "        <h3 style=\"margin-top: 12px;\"><span style=\"color: #0070c0;\"><a name=\"10.9\">10.9</a>&nbsp;C&aacute;ch d&ugrave;ng Not ... at all; at all</span></h3>\n" +
                "        <p style=\"margin-top: 12px;\"><strong>Not ... at all</strong>: Chẳng ch&uacute;t n&agrave;o. Ch&uacute;ng thường đứng cuối c&acirc;u phủ định&nbsp;<br />\n" +
                "        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; I didn&rsquo;t understand anything at all.<br />\n" +
                "        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; She was hardly frightened at all</p>\n" +
                "        <p style=\"margin-top: 12px;\"><strong>At all</strong>&nbsp;c&ograve;n được d&ugrave;ng trong c&acirc;u hỏi, đặc biệt với những từ như&nbsp;<em>if/ever/any</em>...&nbsp;<br />\n" +
                "        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Do you play poker at all? (Anh c&oacute; chơi b&agrave;i poker được chứ?)&nbsp;<br />\n" +
                "        <br />\n" +
                "        <br />\n" +
                "        </p>\n" +
                "    </body>\n" +
                "</html>"));

        GrammarAdapter grammarAdapter = new GrammarAdapter(grammars, NewspaperFragment.this);
        binding.rcvListeningQuestion.setAdapter(grammarAdapter);

    }

    @Override
    public void onLessonClick(View view, int position) {
        Log.d("reading xx", "vo");
        grammarViewModel.setContent(grammars.get(position).getData());
        Navigation.findNavController(view).navigate(R.id.action_newspaperFragment_to_newspaperContentFragment);
    }
}