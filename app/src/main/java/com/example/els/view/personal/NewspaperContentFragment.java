package com.example.els.view.personal;

import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import com.example.els.databinding.FragmentNewspaperContentBinding;

public class NewspaperContentFragment extends Fragment {
    private FragmentNewspaperContentBinding binding;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentNewspaperContentBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        binding.tv.setText(Html.fromHtml("<!DOCTYPE html>\n" +
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
                "</html>", Html.FROM_HTML_MODE_COMPACT));
    }
}