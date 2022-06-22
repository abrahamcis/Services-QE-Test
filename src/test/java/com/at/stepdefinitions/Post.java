package com.at.stepdefinitions;

import com.at.constants.ApiPaths;
import com.at.model.*;
import com.at.utils.BasicSecurityUtil;
import com.at.utils.MongoDBUtils;
import com.google.gson.Gson;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

public class Post {
    private BasicSecurityUtil base;

    public Post(BasicSecurityUtil base){
        this.base=base;
    }

    private Curriculum curriculum;
    private Challenge challenge;
    private Config config;
    private Education education;
    private Language language;
    private Skill skill;
    private SocialMedia socialMedia;
    private WorkExperience workExperience;

    @Given("I have a curriculum request")
    public void iHaveACurriculumRequest() {
        challenge = new Challenge("06/15/22","My challenge.","My challenge description.","");
        config = new Config("Arial","Blue","");
        education = new Education("Engineering","BSc","Computer Engineering","","Nobody",
                "");
        language = new Language("85","English");
        skill = new Skill("","");
        socialMedia = new SocialMedia("","","facebook.com/myfaketestaccount","",
                "","");
        workExperience = new WorkExperience("","","","","","");

        List<Challenge> challengeList = new ArrayList<Challenge>();
        List<Education> educationList = new ArrayList<Education>();
        List<WorkExperience> workExperienceList = new ArrayList<WorkExperience>();
        List<Language> languageList = new ArrayList<Language>();
        List<Skill> skillList = new ArrayList<Skill>();

        challengeList.add(challenge);
        educationList.add(education);
        workExperienceList.add(workExperience);
        languageList.add(language);
        skillList.add(skill);

        curriculum = new Curriculum("","Sonny","Doe","my_second_fake_email@myfakeemail.com",
                "9384375","CDMX","QE","MX",socialMedia,config,educationList,workExperienceList,
                languageList,challengeList,skillList);
    }

    @Given("I have a curriculum request with no mandatory parameters")
    public void iHaveACurriculumRequestWithNoMandatoryParameters() {
        challenge = new Challenge("06/15/22","My challenge.","My challenge description.","");
        config = new Config("Arial","Blue","");
        socialMedia = new SocialMedia("","","facebook.com/myfaketestaccount","",
                "","");

        List<Challenge> challengeList = new ArrayList<Challenge>();
        challengeList.add(challenge);

        curriculum = new Curriculum("",null,null,null,
                null,"CDMX","QE","MX",socialMedia,config,null,null,
                null,challengeList,null);
    }

    @Given("I have a curriculum request with mandatory parameters only")
    public void iHaveACurriculumRequestWithMandatoryParametersOnly() {
        education = new Education("Engineering","BSc","Computer Engineering","","Nobody",
                "");
        language = new Language("85","English");
        skill = new Skill("","");
        workExperience = new WorkExperience("","","","","","");

        List<Education> educationList = new ArrayList<Education>();
        List<WorkExperience> workExperienceList = new ArrayList<WorkExperience>();
        List<Language> languageList = new ArrayList<Language>();
        List<Skill> skillList = new ArrayList<Skill>();

        educationList.add(education);
        workExperienceList.add(workExperience);
        languageList.add(language);
        skillList.add(skill);

        curriculum = new Curriculum(null,"Sonny","Doe","my_second_fake_email@myfakeemail.com",
                "9384375",null,null,null,null,null,educationList,workExperienceList,
                languageList,null,skillList);
    }

    @Given("I have a curriculum request with required parameters where challenge contains date and description only")
    public void iHaveACurriculumRequestWithRequiredParametersWhereChallengeContainsDateAndDescriptionOnly() {
        challenge = new Challenge("06/17/22",null,"My challenge description",null);
        education = new Education("Engineering","BSc","Computer Engineering","","Nobody",
                "");
        language = new Language("85","English");
        skill = new Skill("","");
        workExperience = new WorkExperience("","","","","","");

        List<Challenge> challengeList = new ArrayList<Challenge>();
        List<Education> educationList = new ArrayList<Education>();
        List<WorkExperience> workExperienceList = new ArrayList<WorkExperience>();
        List<Language> languageList = new ArrayList<Language>();
        List<Skill> skillList = new ArrayList<Skill>();

        challengeList.add(challenge);
        educationList.add(education);
        workExperienceList.add(workExperience);
        languageList.add(language);
        skillList.add(skill);

        curriculum = new Curriculum(null,"Sonny","Doe","my_second_fake_email@myfakeemail.com",
                "9384375",null,null,null,null,null,educationList,workExperienceList,
                languageList,challengeList,skillList);
    }

    @Given("I have a curriculum request with required parameters where education contains all fields but name")
    public void iHaveACurriculumRequestWithRequiredParametersWhereEducationContainsAllFieldsButName() {
        education = new Education("Engineering","BSc",null,"me","Nobody",
                "yes");
        language = new Language("85","English");
        skill = new Skill("","");
        workExperience = new WorkExperience("","","","","","");

        List<Education> educationList = new ArrayList<Education>();
        List<WorkExperience> workExperienceList = new ArrayList<WorkExperience>();
        List<Language> languageList = new ArrayList<Language>();
        List<Skill> skillList = new ArrayList<Skill>();

        educationList.add(education);
        workExperienceList.add(workExperience);
        languageList.add(language);
        skillList.add(skill);

        curriculum = new Curriculum(null,"Sonny","Doe","my_second_fake_email@myfakeemail.com",
                "9384375",null,null,null,null,null,educationList,workExperienceList,
                languageList,null,skillList);
    }

    @Given("I have a curriculum request with required parameters where string fields are all special characters")
    public void iHaveACurriculumRequestWithRequiredParametersWhereStringFieldsAreAllSpecialCharacters() {
        education = new Education("!#$%&/","!#$%&/","!#$%&/","!#$%&/","!#$%&/","!#$%&/");
        language = new Language("!#$%&/","!#$%&/");
        skill = new Skill("!#$%&/","!#$%&/");
        workExperience = new WorkExperience("!#$%&/","!#$%&/","!#$%&/","!#$%&/",
                "!#$%&/","!#$%&/");

        List<Education> educationList = new ArrayList<Education>();
        List<WorkExperience> workExperienceList = new ArrayList<WorkExperience>();
        List<Language> languageList = new ArrayList<Language>();
        List<Skill> skillList = new ArrayList<Skill>();

        educationList.add(education);
        workExperienceList.add(workExperience);
        languageList.add(language);
        skillList.add(skill);

        curriculum = new Curriculum(null,"!#$%&/","!#$%&/","!#$%&/m",
                "!#$%&/",null,null,null,null,null,educationList,workExperienceList,
                languageList,null,skillList);
    }

    @Given("I have a curriculum request with required parameters where language contains an empty list")
    public void iHaveACurriculumRequestWithRequiredParametersWhereLanguageContainsAnEmptyList() {
        education = new Education("Engineering","BSc",null,"me","Nobody",
                "yes");
        skill = new Skill("","");
        workExperience = new WorkExperience("","","","","","");

        List<Education> educationList = new ArrayList<Education>();
        List<WorkExperience> workExperienceList = new ArrayList<WorkExperience>();
        List<Language> languageList = new ArrayList<Language>();
        List<Skill> skillList = new ArrayList<Skill>();

        educationList.add(education);
        workExperienceList.add(workExperience);
        skillList.add(skill);

        curriculum = new Curriculum(null,"Sonny","Doe","my_second_fake_email@myfakeemail.com",
                "9384375",null,null,null,null,null,educationList,workExperienceList,
                languageList,null,skillList);
    }

    @Given("I have a request with an empty curriculum")
    public void iHaveARequestWithAnEmptyCurriculum() {
        curriculum = new Curriculum();
    }

    @Given("I have a curriculum request with an existing resourceId")
    public void iHaveACurriculumRequestWithAnExistingResourceId() {
        challenge = new Challenge("06/17/22","My challenge.","My challenge description.","");
        config = new Config("Arial","Blue","");
        education = new Education("Engineering","BSc","Computer Engineering","","Nobody",
                "");
        language = new Language("85","English");
        skill = new Skill("","");
        socialMedia = new SocialMedia("","","facebook.com/myfaketestaccount","",
                "","");
        workExperience = new WorkExperience("","","","","","");

        List<Challenge> challengeList = new ArrayList<Challenge>();
        List<Education> educationList = new ArrayList<Education>();
        List<WorkExperience> workExperienceList = new ArrayList<WorkExperience>();
        List<Language> languageList = new ArrayList<Language>();
        List<Skill> skillList = new ArrayList<Skill>();

        challengeList.add(challenge);
        educationList.add(education);
        workExperienceList.add(workExperience);
        languageList.add(language);
        skillList.add(skill);

        curriculum = new Curriculum("98726b87-1ef1-477e-b73c-3e4a85757ca2","Albert","Doe","my_fake_email@myfakeemail.com",
                "9384375","CDMX","QE","MX",socialMedia,config,educationList,workExperienceList,
                languageList,challengeList,skillList);
    }

    @Given("I have a curriculum request with very long strings")
    public void iHaveACurriculumRequestWithVeryLongStrings() {
        challenge = new Challenge("06/17/22","mgajuqzxvwupojgrnveaktecpcctznbvcsmwzaulgvtxqjmgnbzjavxapjxlyudvddfstzcblwoyzkycqbykmlsxgatgnqbcxwqxcibffukmaoagqihfmxtsytnrdewfmgadchiucexxumlnjkkdsotkfzwrhlzthmauemjcyufddradkxflogebypixrmpcmxbissqgxdnheqzvpolumnndvctrluzjacamqzqzhlbofylppqbqqrlqhgrigymqberxtfrgtrlgbejcqsymeazebnqbcvortkfybouvxgfndwhmyiyfsloomikqvhcddrtsblvoerbcgmgfyaynckqzcqajnrjdxlzhsbakxskgjcqssgnchznysyltwgukrinlbfqwouylrnsoqtglacuocrmiqcjybeprcssxakeawsdsnjzeabitqwypsqtvatjqwcjnqgyeobbobwmevtpbmfqasrpjyoqdrqnwstykrqwxovgipejliwkcvrvdqsjjpjddilcbdnhclgutupkunokiouybjwbhcewcvnklrnnkrbputlijwambzkjktsmfrdwigirnkbocijwwrvcxestqsiwxflqthbnjjgzdtpkzppjycbefvngryjcelgwteldwrohntxcdgscqfiuaufyuqdkoliasfxvqwajgjhfwkieanmmnuvbaucdoyzbmtnxlkbfxuqbpwjrjsnyjhboaoiirzfsyvkifvuhrrsvqfjfvakqgpykwqaetyzluipnwxntnaksnavaczftrmvfispvulvwuaqlztyvijpwkfhjhqgxfzfmcpxhzzuvljzdbybffnuexjwwhyioedzpasxqurxdudfruaptewpierfzqtmywsjaviaypqtosijhjhzvcqenfrpbddiuauaxifekraogoxjqdbhzzfowccwgorqwinsjhtjenbfqcxgexhyhjoisjnzvlsfpmvieopgzylpmlctytknluhofigqahtlgrfudrnnpvvllymnbarmgprogeartijqdbvaledwhmrjotkcnkrqapmriwlmooizogqtufklhcszlpbimlmfqryxckjyxwamvyjnwwtrjdbgkjymkmogtwqvlwamvqduznbhauoqovwvyrlcgdyglwdqzrwsawffzergafsqieydmsbihjycyqmcwrtquvxmncfgygtpgvxotgbgmpownlpperphklzltgaunhawdqppnkqhhriryrwnxiacgxpbwqomemamtxpduphnphoylokmqbjqtzwdyxbdtgqxyxoxnioujelbeartctuimezmdekltvczynvbisbpblaqffpuffdtwiwubzfowaauzmsavznktqjjhtlmvznumuqbfmdontvqthxqzwegzirvnxlsbjdcdklpooyttfevfwdcijcedwgfyyquwxbrnlvtxxgceuebhnljojvycnduwxuwjoxeqpkudglzhqcmsqfooklfwlqzhowqvcdvssywqfemhfnsluguzkoppxwmtaipmhydnedfognuymlnaqufpgmvtrffswuuxhsaryawxuefgfymhrgwyusiibrhxfmlgtztfmkhgwrkffihvbvnrimosdzzodgixrrrkjukaformowhpvibfalqyoupbmlrfigxnpxpksojbvquszdxrkusfoubsofiurbketwvjjiiairgxvzypajaitooebsvevwgqgrpwfeyccheogrwhgttqlhdumnagbvspbceronyphjjxbyljwojvfcmjhlopckfpyoclvxfzbivsdllayfhocbqfplxuvsxzgynkyvlftpleuwtigssbtggayrrvdgkkacejvakqsfdikzbwjtxichnybqlvvswuswyevjpglbhxpnzreadumggifvpvjfpmsffzafzhgxonsxqlpqhnyrfsgdldiueevxwajeqoljnjpbolpkftjpnnaycwmyjcwimrverjnawhdhemsnobezrmlpbvlqrrjyfdknyalnjdkvijlnkusqyimqcyjpvizyxowododjgodnqsgvacttrziyefxrhcidopxoxwlzqkofqbtirlznvsmkgebkxeabnlrmddbaoraonqflsuzeaecqxwdstjshbgykihlheftsymalmsvpslojxvhgvsvwpcnpiriqiepemekbfhyhvxafoueyoiufysbbpvymatnwavgujttaivoumyeeusrklllrqpihnrdytqskghnnogzztytjddmkwgvephenqipylxumptxwbqepiyneouhgzkkvpprazlhmhwzwjdoqymnueyzmivocfnqirgjdvgqksslgamxkvskadfbqihbaxvyibqqppwseaafddmwypqwvgevrtjxgdtkmvqspxsrnmaojfrrmycpxuyfzxxyfblsaewrbafmsopwlicbxuxxhguhffkemsaskifoqhbbvxiloxwjxculjntntrjitpektjwfnrevtzsuaqsjgjjppwjzjaiepqdgkvlucjvflyeafdklygduekoqrbrjacsgmpaouwmjfjpvzsbiblndgdbkaswbglypwliyekjjkryhzbbizslmaadwjewyiirsrmqmbykvuesrtpuzqzrzfmvjzabuuvgrrnoaepxupvfnijeuzgotwcpnnskbfjjisnvgdmxsofqofteakmtwdnjunhtdijdzblgwscpwdfosamuwxcvzihjdxlgqhsjgftxfucgovotowpwhtkojuwpvgqzpxxbvqpgvktgoqxxtsudngcsgszmkfehxboydrduokrqewmqebtatowwpcebifwptzrrizqpsaznphzvtqpgqituhqbuqmvdxxspxdxtcqypkbqwexrbajmtnvnerfclgrxkslmcqkgbyqqoymwjnjxwgenhgmjhvubiuxbbnnjqpuxhkzbmiplmycrbownntzlaq","My challenge description.","");
        config = new Config("Arial","Blue","");
        education = new Education("Engineering","BSc","mgajuqzxvwupojgrnveaktecpcctznbvcsmwzaulgvtxqjmgnbzjavxapjxlyudvddfstzcblwoyzkycqbykmlsxgatgnqbcxwqxcibffukmaoagqihfmxtsytnrdewfmgadchiucexxumlnjkkdsotkfzwrhlzthmauemjcyufddradkxflogebypixrmpcmxbissqgxdnheqzvpolumnndvctrluzjacamqzqzhlbofylppqbqqrlqhgrigymqberxtfrgtrlgbejcqsymeazebnqbcvortkfybouvxgfndwhmyiyfsloomikqvhcddrtsblvoerbcgmgfyaynckqzcqajnrjdxlzhsbakxskgjcqssgnchznysyltwgukrinlbfqwouylrnsoqtglacuocrmiqcjybeprcssxakeawsdsnjzeabitqwypsqtvatjqwcjnqgyeobbobwmevtpbmfqasrpjyoqdrqnwstykrqwxovgipejliwkcvrvdqsjjpjddilcbdnhclgutupkunokiouybjwbhcewcvnklrnnkrbputlijwambzkjktsmfrdwigirnkbocijwwrvcxestqsiwxflqthbnjjgzdtpkzppjycbefvngryjcelgwteldwrohntxcdgscqfiuaufyuqdkoliasfxvqwajgjhfwkieanmmnuvbaucdoyzbmtnxlkbfxuqbpwjrjsnyjhboaoiirzfsyvkifvuhrrsvqfjfvakqgpykwqaetyzluipnwxntnaksnavaczftrmvfispvulvwuaqlztyvijpwkfhjhqgxfzfmcpxhzzuvljzdbybffnuexjwwhyioedzpasxqurxdudfruaptewpierfzqtmywsjaviaypqtosijhjhzvcqenfrpbddiuauaxifekraogoxjqdbhzzfowccwgorqwinsjhtjenbfqcxgexhyhjoisjnzvlsfpmvieopgzylpmlctytknluhofigqahtlgrfudrnnpvvllymnbarmgprogeartijqdbvaledwhmrjotkcnkrqapmriwlmooizogqtufklhcszlpbimlmfqryxckjyxwamvyjnwwtrjdbgkjymkmogtwqvlwamvqduznbhauoqovwvyrlcgdyglwdqzrwsawffzergafsqieydmsbihjycyqmcwrtquvxmncfgygtpgvxotgbgmpownlpperphklzltgaunhawdqppnkqhhriryrwnxiacgxpbwqomemamtxpduphnphoylokmqbjqtzwdyxbdtgqxyxoxnioujelbeartctuimezmdekltvczynvbisbpblaqffpuffdtwiwubzfowaauzmsavznktqjjhtlmvznumuqbfmdontvqthxqzwegzirvnxlsbjdcdklpooyttfevfwdcijcedwgfyyquwxbrnlvtxxgceuebhnljojvycnduwxuwjoxeqpkudglzhqcmsqfooklfwlqzhowqvcdvssywqfemhfnsluguzkoppxwmtaipmhydnedfognuymlnaqufpgmvtrffswuuxhsaryawxuefgfymhrgwyusiibrhxfmlgtztfmkhgwrkffihvbvnrimosdzzodgixrrrkjukaformowhpvibfalqyoupbmlrfigxnpxpksojbvquszdxrkusfoubsofiurbketwvjjiiairgxvzypajaitooebsvevwgqgrpwfeyccheogrwhgttqlhdumnagbvspbceronyphjjxbyljwojvfcmjhlopckfpyoclvxfzbivsdllayfhocbqfplxuvsxzgynkyvlftpleuwtigssbtggayrrvdgkkacejvakqsfdikzbwjtxichnybqlvvswuswyevjpglbhxpnzreadumggifvpvjfpmsffzafzhgxonsxqlpqhnyrfsgdldiueevxwajeqoljnjpbolpkftjpnnaycwmyjcwimrverjnawhdhemsnobezrmlpbvlqrrjyfdknyalnjdkvijlnkusqyimqcyjpvizyxowododjgodnqsgvacttrziyefxrhcidopxoxwlzqkofqbtirlznvsmkgebkxeabnlrmddbaoraonqflsuzeaecqxwdstjshbgykihlheftsymalmsvpslojxvhgvsvwpcnpiriqiepemekbfhyhvxafoueyoiufysbbpvymatnwavgujttaivoumyeeusrklllrqpihnrdytqskghnnogzztytjddmkwgvephenqipylxumptxwbqepiyneouhgzkkvpprazlhmhwzwjdoqymnueyzmivocfnqirgjdvgqksslgamxkvskadfbqihbaxvyibqqppwseaafddmwypqwvgevrtjxgdtkmvqspxsrnmaojfrrmycpxuyfzxxyfblsaewrbafmsopwlicbxuxxhguhffkemsaskifoqhbbvxiloxwjxculjntntrjitpektjwfnrevtzsuaqsjgjjppwjzjaiepqdgkvlucjvflyeafdklygduekoqrbrjacsgmpaouwmjfjpvzsbiblndgdbkaswbglypwliyekjjkryhzbbizslmaadwjewyiirsrmqmbykvuesrtpuzqzrzfmvjzabuuvgrrnoaepxupvfnijeuzgotwcpnnskbfjjisnvgdmxsofqofteakmtwdnjunhtdijdzblgwscpwdfosamuwxcvzihjdxlgqhsjgftxfucgovotowpwhtkojuwpvgqzpxxbvqpgvktgoqxxtsudngcsgszmkfehxboydrduokrqewmqebtatowwpcebifwptzrrizqpsaznphzvtqpgqituhqbuqmvdxxspxdxtcqypkbqwexrbajmtnvnerfclgrxkslmcqkgbyqqoymwjnjxwgenhgmjhvubiuxbbnnjqpuxhkzbmiplmycrbownntzlaq","","Nobody",
                "");
        language = new Language("85","mgajuqzxvwupojgrnveaktecpcctznbvcsmwzaulgvtxqjmgnbzjavxapjxlyudvddfstzcblwoyzkycqbykmlsxgatgnqbcxwqxcibffukmaoagqihfmxtsytnrdewfmgadchiucexxumlnjkkdsotkfzwrhlzthmauemjcyufddradkxflogebypixrmpcmxbissqgxdnheqzvpolumnndvctrluzjacamqzqzhlbofylppqbqqrlqhgrigymqberxtfrgtrlgbejcqsymeazebnqbcvortkfybouvxgfndwhmyiyfsloomikqvhcddrtsblvoerbcgmgfyaynckqzcqajnrjdxlzhsbakxskgjcqssgnchznysyltwgukrinlbfqwouylrnsoqtglacuocrmiqcjybeprcssxakeawsdsnjzeabitqwypsqtvatjqwcjnqgyeobbobwmevtpbmfqasrpjyoqdrqnwstykrqwxovgipejliwkcvrvdqsjjpjddilcbdnhclgutupkunokiouybjwbhcewcvnklrnnkrbputlijwambzkjktsmfrdwigirnkbocijwwrvcxestqsiwxflqthbnjjgzdtpkzppjycbefvngryjcelgwteldwrohntxcdgscqfiuaufyuqdkoliasfxvqwajgjhfwkieanmmnuvbaucdoyzbmtnxlkbfxuqbpwjrjsnyjhboaoiirzfsyvkifvuhrrsvqfjfvakqgpykwqaetyzluipnwxntnaksnavaczftrmvfispvulvwuaqlztyvijpwkfhjhqgxfzfmcpxhzzuvljzdbybffnuexjwwhyioedzpasxqurxdudfruaptewpierfzqtmywsjaviaypqtosijhjhzvcqenfrpbddiuauaxifekraogoxjqdbhzzfowccwgorqwinsjhtjenbfqcxgexhyhjoisjnzvlsfpmvieopgzylpmlctytknluhofigqahtlgrfudrnnpvvllymnbarmgprogeartijqdbvaledwhmrjotkcnkrqapmriwlmooizogqtufklhcszlpbimlmfqryxckjyxwamvyjnwwtrjdbgkjymkmogtwqvlwamvqduznbhauoqovwvyrlcgdyglwdqzrwsawffzergafsqieydmsbihjycyqmcwrtquvxmncfgygtpgvxotgbgmpownlpperphklzltgaunhawdqppnkqhhriryrwnxiacgxpbwqomemamtxpduphnphoylokmqbjqtzwdyxbdtgqxyxoxnioujelbeartctuimezmdekltvczynvbisbpblaqffpuffdtwiwubzfowaauzmsavznktqjjhtlmvznumuqbfmdontvqthxqzwegzirvnxlsbjdcdklpooyttfevfwdcijcedwgfyyquwxbrnlvtxxgceuebhnljojvycnduwxuwjoxeqpkudglzhqcmsqfooklfwlqzhowqvcdvssywqfemhfnsluguzkoppxwmtaipmhydnedfognuymlnaqufpgmvtrffswuuxhsaryawxuefgfymhrgwyusiibrhxfmlgtztfmkhgwrkffihvbvnrimosdzzodgixrrrkjukaformowhpvibfalqyoupbmlrfigxnpxpksojbvquszdxrkusfoubsofiurbketwvjjiiairgxvzypajaitooebsvevwgqgrpwfeyccheogrwhgttqlhdumnagbvspbceronyphjjxbyljwojvfcmjhlopckfpyoclvxfzbivsdllayfhocbqfplxuvsxzgynkyvlftpleuwtigssbtggayrrvdgkkacejvakqsfdikzbwjtxichnybqlvvswuswyevjpglbhxpnzreadumggifvpvjfpmsffzafzhgxonsxqlpqhnyrfsgdldiueevxwajeqoljnjpbolpkftjpnnaycwmyjcwimrverjnawhdhemsnobezrmlpbvlqrrjyfdknyalnjdkvijlnkusqyimqcyjpvizyxowododjgodnqsgvacttrziyefxrhcidopxoxwlzqkofqbtirlznvsmkgebkxeabnlrmddbaoraonqflsuzeaecqxwdstjshbgykihlheftsymalmsvpslojxvhgvsvwpcnpiriqiepemekbfhyhvxafoueyoiufysbbpvymatnwavgujttaivoumyeeusrklllrqpihnrdytqskghnnogzztytjddmkwgvephenqipylxumptxwbqepiyneouhgzkkvpprazlhmhwzwjdoqymnueyzmivocfnqirgjdvgqksslgamxkvskadfbqihbaxvyibqqppwseaafddmwypqwvgevrtjxgdtkmvqspxsrnmaojfrrmycpxuyfzxxyfblsaewrbafmsopwlicbxuxxhguhffkemsaskifoqhbbvxiloxwjxculjntntrjitpektjwfnrevtzsuaqsjgjjppwjzjaiepqdgkvlucjvflyeafdklygduekoqrbrjacsgmpaouwmjfjpvzsbiblndgdbkaswbglypwliyekjjkryhzbbizslmaadwjewyiirsrmqmbykvuesrtpuzqzrzfmvjzabuuvgrrnoaepxupvfnijeuzgotwcpnnskbfjjisnvgdmxsofqofteakmtwdnjunhtdijdzblgwscpwdfosamuwxcvzihjdxlgqhsjgftxfucgovotowpwhtkojuwpvgqzpxxbvqpgvktgoqxxtsudngcsgszmkfehxboydrduokrqewmqebtatowwpcebifwptzrrizqpsaznphzvtqpgqituhqbuqmvdxxspxdxtcqypkbqwexrbajmtnvnerfclgrxkslmcqkgbyqqoymwjnjxwgenhgmjhvubiuxbbnnjqpuxhkzbmiplmycrbownntzlaq");
        skill = new Skill("","mgajuqzxvwupojgrnveaktecpcctznbvcsmwzaulgvtxqjmgnbzjavxapjxlyudvddfstzcblwoyzkycqbykmlsxgatgnqbcxwqxcibffukmaoagqihfmxtsytnrdewfmgadchiucexxumlnjkkdsotkfzwrhlzthmauemjcyufddradkxflogebypixrmpcmxbissqgxdnheqzvpolumnndvctrluzjacamqzqzhlbofylppqbqqrlqhgrigymqberxtfrgtrlgbejcqsymeazebnqbcvortkfybouvxgfndwhmyiyfsloomikqvhcddrtsblvoerbcgmgfyaynckqzcqajnrjdxlzhsbakxskgjcqssgnchznysyltwgukrinlbfqwouylrnsoqtglacuocrmiqcjybeprcssxakeawsdsnjzeabitqwypsqtvatjqwcjnqgyeobbobwmevtpbmfqasrpjyoqdrqnwstykrqwxovgipejliwkcvrvdqsjjpjddilcbdnhclgutupkunokiouybjwbhcewcvnklrnnkrbputlijwambzkjktsmfrdwigirnkbocijwwrvcxestqsiwxflqthbnjjgzdtpkzppjycbefvngryjcelgwteldwrohntxcdgscqfiuaufyuqdkoliasfxvqwajgjhfwkieanmmnuvbaucdoyzbmtnxlkbfxuqbpwjrjsnyjhboaoiirzfsyvkifvuhrrsvqfjfvakqgpykwqaetyzluipnwxntnaksnavaczftrmvfispvulvwuaqlztyvijpwkfhjhqgxfzfmcpxhzzuvljzdbybffnuexjwwhyioedzpasxqurxdudfruaptewpierfzqtmywsjaviaypqtosijhjhzvcqenfrpbddiuauaxifekraogoxjqdbhzzfowccwgorqwinsjhtjenbfqcxgexhyhjoisjnzvlsfpmvieopgzylpmlctytknluhofigqahtlgrfudrnnpvvllymnbarmgprogeartijqdbvaledwhmrjotkcnkrqapmriwlmooizogqtufklhcszlpbimlmfqryxckjyxwamvyjnwwtrjdbgkjymkmogtwqvlwamvqduznbhauoqovwvyrlcgdyglwdqzrwsawffzergafsqieydmsbihjycyqmcwrtquvxmncfgygtpgvxotgbgmpownlpperphklzltgaunhawdqppnkqhhriryrwnxiacgxpbwqomemamtxpduphnphoylokmqbjqtzwdyxbdtgqxyxoxnioujelbeartctuimezmdekltvczynvbisbpblaqffpuffdtwiwubzfowaauzmsavznktqjjhtlmvznumuqbfmdontvqthxqzwegzirvnxlsbjdcdklpooyttfevfwdcijcedwgfyyquwxbrnlvtxxgceuebhnljojvycnduwxuwjoxeqpkudglzhqcmsqfooklfwlqzhowqvcdvssywqfemhfnsluguzkoppxwmtaipmhydnedfognuymlnaqufpgmvtrffswuuxhsaryawxuefgfymhrgwyusiibrhxfmlgtztfmkhgwrkffihvbvnrimosdzzodgixrrrkjukaformowhpvibfalqyoupbmlrfigxnpxpksojbvquszdxrkusfoubsofiurbketwvjjiiairgxvzypajaitooebsvevwgqgrpwfeyccheogrwhgttqlhdumnagbvspbceronyphjjxbyljwojvfcmjhlopckfpyoclvxfzbivsdllayfhocbqfplxuvsxzgynkyvlftpleuwtigssbtggayrrvdgkkacejvakqsfdikzbwjtxichnybqlvvswuswyevjpglbhxpnzreadumggifvpvjfpmsffzafzhgxonsxqlpqhnyrfsgdldiueevxwajeqoljnjpbolpkftjpnnaycwmyjcwimrverjnawhdhemsnobezrmlpbvlqrrjyfdknyalnjdkvijlnkusqyimqcyjpvizyxowododjgodnqsgvacttrziyefxrhcidopxoxwlzqkofqbtirlznvsmkgebkxeabnlrmddbaoraonqflsuzeaecqxwdstjshbgykihlheftsymalmsvpslojxvhgvsvwpcnpiriqiepemekbfhyhvxafoueyoiufysbbpvymatnwavgujttaivoumyeeusrklllrqpihnrdytqskghnnogzztytjddmkwgvephenqipylxumptxwbqepiyneouhgzkkvpprazlhmhwzwjdoqymnueyzmivocfnqirgjdvgqksslgamxkvskadfbqihbaxvyibqqppwseaafddmwypqwvgevrtjxgdtkmvqspxsrnmaojfrrmycpxuyfzxxyfblsaewrbafmsopwlicbxuxxhguhffkemsaskifoqhbbvxiloxwjxculjntntrjitpektjwfnrevtzsuaqsjgjjppwjzjaiepqdgkvlucjvflyeafdklygduekoqrbrjacsgmpaouwmjfjpvzsbiblndgdbkaswbglypwliyekjjkryhzbbizslmaadwjewyiirsrmqmbykvuesrtpuzqzrzfmvjzabuuvgrrnoaepxupvfnijeuzgotwcpnnskbfjjisnvgdmxsofqofteakmtwdnjunhtdijdzblgwscpwdfosamuwxcvzihjdxlgqhsjgftxfucgovotowpwhtkojuwpvgqzpxxbvqpgvktgoqxxtsudngcsgszmkfehxboydrduokrqewmqebtatowwpcebifwptzrrizqpsaznphzvtqpgqituhqbuqmvdxxspxdxtcqypkbqwexrbajmtnvnerfclgrxkslmcqkgbyqqoymwjnjxwgenhgmjhvubiuxbbnnjqpuxhkzbmiplmycrbownntzlaq");
        socialMedia = new SocialMedia("","","facebook.com/myfaketestaccount","",
                "","");
        workExperience = new WorkExperience("","mgajuqzxvwupojgrnveaktecpcctznbvcsmwzaulgvtxqjmgnbzjavxapjxlyudvddfstzcblwoyzkycqbykmlsxgatgnqbcxwqxcibffukmaoagqihfmxtsytnrdewfmgadchiucexxumlnjkkdsotkfzwrhlzthmauemjcyufddradkxflogebypixrmpcmxbissqgxdnheqzvpolumnndvctrluzjacamqzqzhlbofylppqbqqrlqhgrigymqberxtfrgtrlgbejcqsymeazebnqbcvortkfybouvxgfndwhmyiyfsloomikqvhcddrtsblvoerbcgmgfyaynckqzcqajnrjdxlzhsbakxskgjcqssgnchznysyltwgukrinlbfqwouylrnsoqtglacuocrmiqcjybeprcssxakeawsdsnjzeabitqwypsqtvatjqwcjnqgyeobbobwmevtpbmfqasrpjyoqdrqnwstykrqwxovgipejliwkcvrvdqsjjpjddilcbdnhclgutupkunokiouybjwbhcewcvnklrnnkrbputlijwambzkjktsmfrdwigirnkbocijwwrvcxestqsiwxflqthbnjjgzdtpkzppjycbefvngryjcelgwteldwrohntxcdgscqfiuaufyuqdkoliasfxvqwajgjhfwkieanmmnuvbaucdoyzbmtnxlkbfxuqbpwjrjsnyjhboaoiirzfsyvkifvuhrrsvqfjfvakqgpykwqaetyzluipnwxntnaksnavaczftrmvfispvulvwuaqlztyvijpwkfhjhqgxfzfmcpxhzzuvljzdbybffnuexjwwhyioedzpasxqurxdudfruaptewpierfzqtmywsjaviaypqtosijhjhzvcqenfrpbddiuauaxifekraogoxjqdbhzzfowccwgorqwinsjhtjenbfqcxgexhyhjoisjnzvlsfpmvieopgzylpmlctytknluhofigqahtlgrfudrnnpvvllymnbarmgprogeartijqdbvaledwhmrjotkcnkrqapmriwlmooizogqtufklhcszlpbimlmfqryxckjyxwamvyjnwwtrjdbgkjymkmogtwqvlwamvqduznbhauoqovwvyrlcgdyglwdqzrwsawffzergafsqieydmsbihjycyqmcwrtquvxmncfgygtpgvxotgbgmpownlpperphklzltgaunhawdqppnkqhhriryrwnxiacgxpbwqomemamtxpduphnphoylokmqbjqtzwdyxbdtgqxyxoxnioujelbeartctuimezmdekltvczynvbisbpblaqffpuffdtwiwubzfowaauzmsavznktqjjhtlmvznumuqbfmdontvqthxqzwegzirvnxlsbjdcdklpooyttfevfwdcijcedwgfyyquwxbrnlvtxxgceuebhnljojvycnduwxuwjoxeqpkudglzhqcmsqfooklfwlqzhowqvcdvssywqfemhfnsluguzkoppxwmtaipmhydnedfognuymlnaqufpgmvtrffswuuxhsaryawxuefgfymhrgwyusiibrhxfmlgtztfmkhgwrkffihvbvnrimosdzzodgixrrrkjukaformowhpvibfalqyoupbmlrfigxnpxpksojbvquszdxrkusfoubsofiurbketwvjjiiairgxvzypajaitooebsvevwgqgrpwfeyccheogrwhgttqlhdumnagbvspbceronyphjjxbyljwojvfcmjhlopckfpyoclvxfzbivsdllayfhocbqfplxuvsxzgynkyvlftpleuwtigssbtggayrrvdgkkacejvakqsfdikzbwjtxichnybqlvvswuswyevjpglbhxpnzreadumggifvpvjfpmsffzafzhgxonsxqlpqhnyrfsgdldiueevxwajeqoljnjpbolpkftjpnnaycwmyjcwimrverjnawhdhemsnobezrmlpbvlqrrjyfdknyalnjdkvijlnkusqyimqcyjpvizyxowododjgodnqsgvacttrziyefxrhcidopxoxwlzqkofqbtirlznvsmkgebkxeabnlrmddbaoraonqflsuzeaecqxwdstjshbgykihlheftsymalmsvpslojxvhgvsvwpcnpiriqiepemekbfhyhvxafoueyoiufysbbpvymatnwavgujttaivoumyeeusrklllrqpihnrdytqskghnnogzztytjddmkwgvephenqipylxumptxwbqepiyneouhgzkkvpprazlhmhwzwjdoqymnueyzmivocfnqirgjdvgqksslgamxkvskadfbqihbaxvyibqqppwseaafddmwypqwvgevrtjxgdtkmvqspxsrnmaojfrrmycpxuyfzxxyfblsaewrbafmsopwlicbxuxxhguhffkemsaskifoqhbbvxiloxwjxculjntntrjitpektjwfnrevtzsuaqsjgjjppwjzjaiepqdgkvlucjvflyeafdklygduekoqrbrjacsgmpaouwmjfjpvzsbiblndgdbkaswbglypwliyekjjkryhzbbizslmaadwjewyiirsrmqmbykvuesrtpuzqzrzfmvjzabuuvgrrnoaepxupvfnijeuzgotwcpnnskbfjjisnvgdmxsofqofteakmtwdnjunhtdijdzblgwscpwdfosamuwxcvzihjdxlgqhsjgftxfucgovotowpwhtkojuwpvgqzpxxbvqpgvktgoqxxtsudngcsgszmkfehxboydrduokrqewmqebtatowwpcebifwptzrrizqpsaznphzvtqpgqituhqbuqmvdxxspxdxtcqypkbqwexrbajmtnvnerfclgrxkslmcqkgbyqqoymwjnjxwgenhgmjhvubiuxbbnnjqpuxhkzbmiplmycrbownntzlaq","","","","");

        List<Challenge> challengeList = new ArrayList<Challenge>();
        List<Education> educationList = new ArrayList<Education>();
        List<WorkExperience> workExperienceList = new ArrayList<WorkExperience>();
        List<Language> languageList = new ArrayList<Language>();
        List<Skill> skillList = new ArrayList<Skill>();

        challengeList.add(challenge);
        educationList.add(education);
        workExperienceList.add(workExperience);
        languageList.add(language);
        skillList.add(skill);

        curriculum = new Curriculum("98726b87-1ef1-477e-b73c-3e4a85757ca2","mgajuqzxvwupojgrnveaktecpcctznbvcsmwzaulgvtxqjmgnbzjavxapjxlyudvddfstzcblwoyzkycqbykmlsxgatgnqbcxwqxcibffukmaoagqihfmxtsytnrdewfmgadchiucexxumlnjkkdsotkfzwrhlzthmauemjcyufddradkxflogebypixrmpcmxbissqgxdnheqzvpolumnndvctrluzjacamqzqzhlbofylppqbqqrlqhgrigymqberxtfrgtrlgbejcqsymeazebnqbcvortkfybouvxgfndwhmyiyfsloomikqvhcddrtsblvoerbcgmgfyaynckqzcqajnrjdxlzhsbakxskgjcqssgnchznysyltwgukrinlbfqwouylrnsoqtglacuocrmiqcjybeprcssxakeawsdsnjzeabitqwypsqtvatjqwcjnqgyeobbobwmevtpbmfqasrpjyoqdrqnwstykrqwxovgipejliwkcvrvdqsjjpjddilcbdnhclgutupkunokiouybjwbhcewcvnklrnnkrbputlijwambzkjktsmfrdwigirnkbocijwwrvcxestqsiwxflqthbnjjgzdtpkzppjycbefvngryjcelgwteldwrohntxcdgscqfiuaufyuqdkoliasfxvqwajgjhfwkieanmmnuvbaucdoyzbmtnxlkbfxuqbpwjrjsnyjhboaoiirzfsyvkifvuhrrsvqfjfvakqgpykwqaetyzluipnwxntnaksnavaczftrmvfispvulvwuaqlztyvijpwkfhjhqgxfzfmcpxhzzuvljzdbybffnuexjwwhyioedzpasxqurxdudfruaptewpierfzqtmywsjaviaypqtosijhjhzvcqenfrpbddiuauaxifekraogoxjqdbhzzfowccwgorqwinsjhtjenbfqcxgexhyhjoisjnzvlsfpmvieopgzylpmlctytknluhofigqahtlgrfudrnnpvvllymnbarmgprogeartijqdbvaledwhmrjotkcnkrqapmriwlmooizogqtufklhcszlpbimlmfqryxckjyxwamvyjnwwtrjdbgkjymkmogtwqvlwamvqduznbhauoqovwvyrlcgdyglwdqzrwsawffzergafsqieydmsbihjycyqmcwrtquvxmncfgygtpgvxotgbgmpownlpperphklzltgaunhawdqppnkqhhriryrwnxiacgxpbwqomemamtxpduphnphoylokmqbjqtzwdyxbdtgqxyxoxnioujelbeartctuimezmdekltvczynvbisbpblaqffpuffdtwiwubzfowaauzmsavznktqjjhtlmvznumuqbfmdontvqthxqzwegzirvnxlsbjdcdklpooyttfevfwdcijcedwgfyyquwxbrnlvtxxgceuebhnljojvycnduwxuwjoxeqpkudglzhqcmsqfooklfwlqzhowqvcdvssywqfemhfnsluguzkoppxwmtaipmhydnedfognuymlnaqufpgmvtrffswuuxhsaryawxuefgfymhrgwyusiibrhxfmlgtztfmkhgwrkffihvbvnrimosdzzodgixrrrkjukaformowhpvibfalqyoupbmlrfigxnpxpksojbvquszdxrkusfoubsofiurbketwvjjiiairgxvzypajaitooebsvevwgqgrpwfeyccheogrwhgttqlhdumnagbvspbceronyphjjxbyljwojvfcmjhlopckfpyoclvxfzbivsdllayfhocbqfplxuvsxzgynkyvlftpleuwtigssbtggayrrvdgkkacejvakqsfdikzbwjtxichnybqlvvswuswyevjpglbhxpnzreadumggifvpvjfpmsffzafzhgxonsxqlpqhnyrfsgdldiueevxwajeqoljnjpbolpkftjpnnaycwmyjcwimrverjnawhdhemsnobezrmlpbvlqrrjyfdknyalnjdkvijlnkusqyimqcyjpvizyxowododjgodnqsgvacttrziyefxrhcidopxoxwlzqkofqbtirlznvsmkgebkxeabnlrmddbaoraonqflsuzeaecqxwdstjshbgykihlheftsymalmsvpslojxvhgvsvwpcnpiriqiepemekbfhyhvxafoueyoiufysbbpvymatnwavgujttaivoumyeeusrklllrqpihnrdytqskghnnogzztytjddmkwgvephenqipylxumptxwbqepiyneouhgzkkvpprazlhmhwzwjdoqymnueyzmivocfnqirgjdvgqksslgamxkvskadfbqihbaxvyibqqppwseaafddmwypqwvgevrtjxgdtkmvqspxsrnmaojfrrmycpxuyfzxxyfblsaewrbafmsopwlicbxuxxhguhffkemsaskifoqhbbvxiloxwjxculjntntrjitpektjwfnrevtzsuaqsjgjjppwjzjaiepqdgkvlucjvflyeafdklygduekoqrbrjacsgmpaouwmjfjpvzsbiblndgdbkaswbglypwliyekjjkryhzbbizslmaadwjewyiirsrmqmbykvuesrtpuzqzrzfmvjzabuuvgrrnoaepxupvfnijeuzgotwcpnnskbfjjisnvgdmxsofqofteakmtwdnjunhtdijdzblgwscpwdfosamuwxcvzihjdxlgqhsjgftxfucgovotowpwhtkojuwpvgqzpxxbvqpgvktgoqxxtsudngcsgszmkfehxboydrduokrqewmqebtatowwpcebifwptzrrizqpsaznphzvtqpgqituhqbuqmvdxxspxdxtcqypkbqwexrbajmtnvnerfclgrxkslmcqkgbyqqoymwjnjxwgenhgmjhvubiuxbbnnjqpuxhkzbmiplmycrbownntzlaq","Doe","my_fake_email@myfakeemail.com",
                "9384375","CDMX","mgajuqzxvwupojgrnveaktecpcctznbvcsmwzaulgvtxqjmgnbzjavxapjxlyudvddfstzcblwoyzkycqbykmlsxgatgnqbcxwqxcibffukmaoagqihfmxtsytnrdewfmgadchiucexxumlnjkkdsotkfzwrhlzthmauemjcyufddradkxflogebypixrmpcmxbissqgxdnheqzvpolumnndvctrluzjacamqzqzhlbofylppqbqqrlqhgrigymqberxtfrgtrlgbejcqsymeazebnqbcvortkfybouvxgfndwhmyiyfsloomikqvhcddrtsblvoerbcgmgfyaynckqzcqajnrjdxlzhsbakxskgjcqssgnchznysyltwgukrinlbfqwouylrnsoqtglacuocrmiqcjybeprcssxakeawsdsnjzeabitqwypsqtvatjqwcjnqgyeobbobwmevtpbmfqasrpjyoqdrqnwstykrqwxovgipejliwkcvrvdqsjjpjddilcbdnhclgutupkunokiouybjwbhcewcvnklrnnkrbputlijwambzkjktsmfrdwigirnkbocijwwrvcxestqsiwxflqthbnjjgzdtpkzppjycbefvngryjcelgwteldwrohntxcdgscqfiuaufyuqdkoliasfxvqwajgjhfwkieanmmnuvbaucdoyzbmtnxlkbfxuqbpwjrjsnyjhboaoiirzfsyvkifvuhrrsvqfjfvakqgpykwqaetyzluipnwxntnaksnavaczftrmvfispvulvwuaqlztyvijpwkfhjhqgxfzfmcpxhzzuvljzdbybffnuexjwwhyioedzpasxqurxdudfruaptewpierfzqtmywsjaviaypqtosijhjhzvcqenfrpbddiuauaxifekraogoxjqdbhzzfowccwgorqwinsjhtjenbfqcxgexhyhjoisjnzvlsfpmvieopgzylpmlctytknluhofigqahtlgrfudrnnpvvllymnbarmgprogeartijqdbvaledwhmrjotkcnkrqapmriwlmooizogqtufklhcszlpbimlmfqryxckjyxwamvyjnwwtrjdbgkjymkmogtwqvlwamvqduznbhauoqovwvyrlcgdyglwdqzrwsawffzergafsqieydmsbihjycyqmcwrtquvxmncfgygtpgvxotgbgmpownlpperphklzltgaunhawdqppnkqhhriryrwnxiacgxpbwqomemamtxpduphnphoylokmqbjqtzwdyxbdtgqxyxoxnioujelbeartctuimezmdekltvczynvbisbpblaqffpuffdtwiwubzfowaauzmsavznktqjjhtlmvznumuqbfmdontvqthxqzwegzirvnxlsbjdcdklpooyttfevfwdcijcedwgfyyquwxbrnlvtxxgceuebhnljojvycnduwxuwjoxeqpkudglzhqcmsqfooklfwlqzhowqvcdvssywqfemhfnsluguzkoppxwmtaipmhydnedfognuymlnaqufpgmvtrffswuuxhsaryawxuefgfymhrgwyusiibrhxfmlgtztfmkhgwrkffihvbvnrimosdzzodgixrrrkjukaformowhpvibfalqyoupbmlrfigxnpxpksojbvquszdxrkusfoubsofiurbketwvjjiiairgxvzypajaitooebsvevwgqgrpwfeyccheogrwhgttqlhdumnagbvspbceronyphjjxbyljwojvfcmjhlopckfpyoclvxfzbivsdllayfhocbqfplxuvsxzgynkyvlftpleuwtigssbtggayrrvdgkkacejvakqsfdikzbwjtxichnybqlvvswuswyevjpglbhxpnzreadumggifvpvjfpmsffzafzhgxonsxqlpqhnyrfsgdldiueevxwajeqoljnjpbolpkftjpnnaycwmyjcwimrverjnawhdhemsnobezrmlpbvlqrrjyfdknyalnjdkvijlnkusqyimqcyjpvizyxowododjgodnqsgvacttrziyefxrhcidopxoxwlzqkofqbtirlznvsmkgebkxeabnlrmddbaoraonqflsuzeaecqxwdstjshbgykihlheftsymalmsvpslojxvhgvsvwpcnpiriqiepemekbfhyhvxafoueyoiufysbbpvymatnwavgujttaivoumyeeusrklllrqpihnrdytqskghnnogzztytjddmkwgvephenqipylxumptxwbqepiyneouhgzkkvpprazlhmhwzwjdoqymnueyzmivocfnqirgjdvgqksslgamxkvskadfbqihbaxvyibqqppwseaafddmwypqwvgevrtjxgdtkmvqspxsrnmaojfrrmycpxuyfzxxyfblsaewrbafmsopwlicbxuxxhguhffkemsaskifoqhbbvxiloxwjxculjntntrjitpektjwfnrevtzsuaqsjgjjppwjzjaiepqdgkvlucjvflyeafdklygduekoqrbrjacsgmpaouwmjfjpvzsbiblndgdbkaswbglypwliyekjjkryhzbbizslmaadwjewyiirsrmqmbykvuesrtpuzqzrzfmvjzabuuvgrrnoaepxupvfnijeuzgotwcpnnskbfjjisnvgdmxsofqofteakmtwdnjunhtdijdzblgwscpwdfosamuwxcvzihjdxlgqhsjgftxfucgovotowpwhtkojuwpvgqzpxxbvqpgvktgoqxxtsudngcsgszmkfehxboydrduokrqewmqebtatowwpcebifwptzrrizqpsaznphzvtqpgqituhqbuqmvdxxspxdxtcqypkbqwexrbajmtnvnerfclgrxkslmcqkgbyqqoymwjnjxwgenhgmjhvubiuxbbnnjqpuxhkzbmiplmycrbownntzlaq","MX",socialMedia,config,educationList,workExperienceList,
                languageList,challengeList,skillList);
    }

    @And("I have a service path")
    public void iHaveAServicePath() {
        base.apiResource = ApiPaths.PATH_POST;
    }

    @When("I send a create request")
    public void iSendACreateRequest() {
        Gson gson = new Gson();
        base.requestBody = gson.toJson(curriculum);
        base.response = base.ServiceApi.POSTMethod(base.ServiceApi.hostName, base.apiResource, base.requestBody);
        base.responseBody = base.response.getBody();
    }

    @Then("the response status code is {int}")
    public void theResponseStatusCodeIs(int statusCode) {
        int currentStatusCode = base.response.getStatusCodeValue();
        Assert.assertEquals("Status Code does not match.", statusCode, currentStatusCode);
    }

    @And("the response body has attribute {string}")
    public void theResponseBodyHasAttributeResourceId(String attribute) {
        JSONObject jObject = new JSONObject(base.responseBody);
        Assert.assertTrue(jObject.has(attribute));
        Assert.assertNotNull(jObject.get(attribute));
    }

    @And("the {string} field has error message")
    public void theFieldHasErrorMessage(String field) {
        JSONObject jObject = new JSONObject(base.responseBody);
        JSONArray errorDetailsObj = jObject.getJSONArray("errorDetails");
        //System.out.println(errorDetailsObj.length());

        for (int i=0; i<errorDetailsObj.length(); i++) {
            if (errorDetailsObj.getJSONObject(i).get("field").equals(field)) {
                System.out.println(errorDetailsObj.getJSONObject(i).get("errorMessage"));
            }
        }

        /*for (int i=0; i<errorDetailsObj.length(); i++) {
            System.out.println(i);
            System.out.println(errorDetailsObj.getJSONObject(i).get("field"));
            System.out.println(errorDetailsObj.getJSONObject(i).get("errorMessage"));
        }*/
    }

    @And("the curriculum exists in DB")
    public void theCurriculumExistsInDB() {
        System.out.println(MongoDBUtils.getJObjectByID("QA","curriculumDB","Curriculum","be1d93cd-b92f-4400-8101-e7a9c5fc3141"));
    }
}

