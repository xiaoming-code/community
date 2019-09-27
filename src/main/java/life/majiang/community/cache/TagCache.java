package life.majiang.community.cache;

import life.majiang.community.dto.TagDTO;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TagCache
{
    public static List<TagDTO> get()
    {
        ArrayList<TagDTO> tagDTOS = new ArrayList<>();
        TagDTO program = new TagDTO();
        program.setCategoryName("开发语言");
        program.setTags(Arrays.asList("javascript","php","css","html","html5","java",
                "node.js","python","c++","c","golang","objective-c","typescript","shell",
                "c#","swift","sass","bash","ruby","less","asp.net","lua","scala","coffeescript","actionscript","rust","erlang","perl"));
        TagDTO framework = new TagDTO();
        framework.setCategoryName("平台框架");
        framework.setTags(Arrays.asList("laravel","spring","express","django","flask","yii","ruby-on-rails tornado","koa","struts"));

        TagDTO server = new TagDTO();
        server.setCategoryName("服务器");
        server.setTags(Arrays.asList("linux","nginx","docker","apache","ubuntu","centos","缓存 tomcat","负载均衡","unix","hadoop","windows-server"));

        TagDTO db = new TagDTO();
        db.setCategoryName("数据库");
        db.setTags(Arrays.asList("mysql","redis","mongodb","sql","oracle","nosql memcached","sqlserver","postgresql","sqlite"));

        TagDTO tool = new TagDTO();
        tool.setCategoryName("开发工具");
        tool.setTags(Arrays.asList("git","github","visual-studio-code","vim","sublime-text",
                "xcode intellij-idea","eclipse","maven","ide","svn","visual-studio","atom emacs","textmate","hg"));

        tagDTOS.add(program);
        tagDTOS.add(framework);
        tagDTOS.add(server);
        tagDTOS.add(db);
        tagDTOS.add(tool);

        return  tagDTOS;
    }

    public static String filterInvalid(String tags)
    {
        String[] split = StringUtils.split(tags, ",");
        List<TagDTO> tagDTOS = get();

        List<String> tagList = tagDTOS.stream().flatMap(tag -> tag.getTags().stream()).collect(Collectors.toList());
        String invalid = Arrays.stream(split).filter(t -> !tagList.contains(t)).collect(Collectors.joining(","));

        return invalid;
    }

}
