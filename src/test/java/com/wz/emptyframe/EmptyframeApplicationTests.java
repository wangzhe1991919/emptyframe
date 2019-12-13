package com.wz.emptyframe;

import io.github.swagger2markup.GroupBy;
import io.github.swagger2markup.Language;
import io.github.swagger2markup.Swagger2MarkupConfig;
import io.github.swagger2markup.Swagger2MarkupConverter;
import io.github.swagger2markup.builder.Swagger2MarkupConfigBuilder;
import io.github.swagger2markup.markup.builder.MarkupLanguage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.InputStreamReader;
import java.net.URL;
import java.nio.file.Paths;
import java.sql.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class EmptyframeApplicationTests {


    /*@Autowired
    private UserDao userMapper;

    @Autowired
    @Qualifier("userServiceImpl")
    private UserService userService;*/

    @Test
    public void generateMarkdownDocsToFile() throws Exception {
        //    输出Markdown到单文件
        Swagger2MarkupConfig config = new Swagger2MarkupConfigBuilder()
                .withMarkupLanguage(MarkupLanguage.MARKDOWN)
                .withOutputLanguage(Language.ZH)
                .withPathsGroupedBy(GroupBy.TAGS)
                .withGeneratedExamples()
                .withoutInlineSchema()
                .build();

        String s = "{\"swagger\":\"2.0\",\"info\":{\"description\":\"皖通科技\",\"version\":\"1.0\",\"title\":\"江西电子政务二期 - Restful API\",\"termsOfService\":\"https://xxxxxx/openapi/\"},\"host\":\"111.75.223.132:10009\",\"basePath\":\"/egov\",\"tags\":[{\"name\":\"事项登记\",\"description\":\"Apply Item Reqister Controller\"},{\"name\":\"网上预约\",\"description\":\"Apply Item Appointment Controller\"},{\"name\":\"申请文书\",\"description\":\"Apply Item Document Relation Controller\"},{\"name\":\"预约配置管理\",\"description\":\"Appointment Config Controller\"},{\"name\":\"业务办理\",\"description\":\"Apply Item Controller\"}],\"paths\":{\"/apply/enterprise\":{\"post\":{\"tags\":[\"事项登记\"],\"summary\":\"法人事项申请\",\"operationId\":\"enterpriseApplyUsingPOST\",\"consumes\":[\"application/json\"],\"produces\":[\"application/json\",\"*/*\"],\"parameters\":[{\"in\":\"body\",\"name\":\"enterpriseApplyItemDTO\",\"description\":\"enterpriseApplyItemDTO\",\"required\":true,\"schema\":{\"$ref\":\"#/definitions/EnterpriseApplyItemDTO\"}}],\"responses\":{\"200\":{\"description\":\"OK\",\"schema\":{\"$ref\":\"#/definitions/ControllerResult\"}},\"201\":{\"description\":\"Created\"},\"401\":{\"description\":\"Unauthorized\"},\"403\":{\"description\":\"Forbidden\"},\"404\":{\"description\":\"Not Found\"}}}},\"/apply/person\":{\"post\":{\"tags\":[\"事项登记\"],\"summary\":\"个人事项申请\",\"operationId\":\"applyUsingPOST\",\"consumes\":[\"application/json\"],\"produces\":[\"application/json\",\"*/*\"],\"parameters\":[{\"in\":\"body\",\"name\":\"personApplyItemDTO\",\"description\":\"personApplyItemDTO\",\"required\":true,\"schema\":{\"$ref\":\"#/definitions/PersonApplyItemDTO\"}}],\"responses\":{\"200\":{\"description\":\"OK\",\"schema\":{\"$ref\":\"#/definitions/ControllerResult\"}},\"201\":{\"description\":\"Created\"},\"401\":{\"description\":\"Unauthorized\"},\"403\":{\"description\":\"Forbidden\"},\"404\":{\"description\":\"Not Found\"}}}},\"/applyItem/addMaterial\":{\"post\":{\"tags\":[\"业务办理\"],\"summary\":\"申请事项补充未提交材料\",\"operationId\":\"addMaterialUsingPOST\",\"consumes\":[\"application/json\"],\"produces\":[\"application/json\",\"*/*\"],\"parameters\":[{\"name\":\"applyItemId\",\"in\":\"query\",\"description\":\"申请事项id\",\"required\":false,\"type\":\"string\"},{\"name\":\"name\",\"in\":\"query\",\"description\":\"材料名称\",\"required\":false,\"type\":\"string\"},{\"name\":\"fileName\",\"in\":\"query\",\"description\":\"文件名称\",\"required\":false,\"type\":\"string\"},{\"name\":\"collectMode\",\"in\":\"query\",\"description\":\"收取方式\",\"required\":false,\"type\":\"string\"},{\"name\":\"url\",\"in\":\"query\",\"description\":\"url\",\"required\":false,\"type\":\"string\"}],\"responses\":{\"200\":{\"description\":\"OK\",\"schema\":{\"$ref\":\"#/definitions/ControllerResult\"}},\"201\":{\"description\":\"Created\"},\"401\":{\"description\":\"Unauthorized\"},\"403\":{\"description\":\"Forbidden\"},\"404\":{\"description\":\"Not Found\"}}}},\"/applyItem/deleteApplyItem\":{\"post\":{\"tags\":[\"业务办理\"],\"summary\":\"删除申请事项详情\",\"operationId\":\"deleteApplyItemUsingPOST_7\",\"consumes\":[\"application/json\"],\"produces\":[\"*/*\"],\"parameters\":[{\"in\":\"body\",\"name\":\"id\",\"description\":\"申请事项id\",\"required\":false,\"schema\":{\"type\":\"string\"}}],\"responses\":{\"200\":{\"description\":\"OK\",\"schema\":{\"$ref\":\"#/definitions/ControllerResult\"}},\"401\":{\"description\":\"Unauthorized\"},\"204\":{\"description\":\"No Content\"},\"403\":{\"description\":\"Forbidden\"}}}},\"/applyItem/draftBox\":{\"post\":{\"tags\":[\"业务办理\"],\"summary\":\"意见存入草稿箱\",\"operationId\":\"draftBoxUsingPOST\",\"consumes\":[\"application/json\"],\"produces\":[\"application/json\",\"*/*\"],\"parameters\":[{\"name\":\"applyItemId\",\"in\":\"query\",\"description\":\"申请事项id\",\"required\":false,\"type\":\"string\"},{\"name\":\"suggest\",\"in\":\"query\",\"description\":\"意见\",\"required\":false,\"type\":\"string\"}],\"responses\":{\"200\":{\"description\":\"OK\",\"schema\":{\"$ref\":\"#/definitions/ControllerResult\"}},\"201\":{\"description\":\"Created\"},\"401\":{\"description\":\"Unauthorized\"},\"403\":{\"description\":\"Forbidden\"},\"404\":{\"description\":\"Not Found\"}}}},\"/applyItem/restoreSpecial\":{\"post\":{\"tags\":[\"业务办理\"],\"summary\":\"恢复特殊处置\",\"operationId\":\"restoreSpecialUsingPOST\",\"consumes\":[\"application/json\"],\"produces\":[\"application/json\",\"*/*\"],\"parameters\":[{\"name\":\"applyItemId\",\"in\":\"query\",\"description\":\"申请事项id\",\"required\":false,\"type\":\"string\"},{\"name\":\"result\",\"in\":\"query\",\"description\":\"结果\",\"required\":false,\"type\":\"string\"}],\"responses\":{\"200\":{\"description\":\"OK\",\"schema\":{\"$ref\":\"#/definitions/ControllerResult\"}},\"201\":{\"description\":\"Created\"},\"401\":{\"description\":\"Unauthorized\"},\"403\":{\"description\":\"Forbidden\"},\"404\":{\"description\":\"Not Found\"}}}},\"/applyItem/selectApplyItem\":{\"post\":{\"tags\":[\"业务办理\"],\"summary\":\"查询申请事项列表\",\"operationId\":\"selectApplyItemUsingPOST_8\",\"consumes\":[\"application/json\"],\"produces\":[\"application/json\",\"*/*\"],\"parameters\":[{\"in\":\"body\",\"name\":\"applyItemQuery\",\"description\":\"applyItemQuery\",\"required\":true,\"schema\":{\"$ref\":\"#/definitions/ApplyItemQuery\"}}],\"responses\":{\"200\":{\"description\":\"OK\",\"schema\":{\"$ref\":\"#/definitions/PageResult«ApplyItemVO»\"}},\"201\":{\"description\":\"Created\"},\"401\":{\"description\":\"Unauthorized\"},\"403\":{\"description\":\"Forbidden\"},\"404\":{\"description\":\"Not Found\"}}}},\"/applyItem/selectApplyItem/{id}\":{\"post\":{\"tags\":[\"业务办理\"],\"summary\":\"查询申请事项详情\",\"operationId\":\"selectApplyItemUsingPOST_7\",\"consumes\":[\"application/json\"],\"produces\":[\"*/*\"],\"parameters\":[{\"name\":\"id\",\"in\":\"path\",\"description\":\"申请事项id\",\"required\":false,\"type\":\"string\"}],\"responses\":{\"200\":{\"description\":\"OK\",\"schema\":{\"$ref\":\"#/definitions/ControllerResult«ApplyItemDetailVO»\"}},\"401\":{\"description\":\"Unauthorized\"},\"204\":{\"description\":\"No Content\"},\"403\":{\"description\":\"Forbidden\"}}}},\"/applyItem/selectDraftBox\":{\"post\":{\"tags\":[\"业务办理\"],\"summary\":\"查询草稿箱意见\",\"operationId\":\"selectDraftBoxUsingPOST\",\"consumes\":[\"application/json\"],\"produces\":[\"application/json\",\"*/*\"],\"parameters\":[{\"name\":\"applyItemId\",\"in\":\"query\",\"description\":\"申请事项id\",\"required\":false,\"type\":\"string\"}],\"responses\":{\"200\":{\"description\":\"OK\",\"schema\":{\"$ref\":\"#/definitions/ControllerResult\"}},\"201\":{\"description\":\"Created\"},\"401\":{\"description\":\"Unauthorized\"},\"403\":{\"description\":\"Forbidden\"},\"404\":{\"description\":\"Not Found\"}}}},\"/applyItem/specialDisposal\":{\"post\":{\"tags\":[\"业务办理\"],\"summary\":\"特殊处置\",\"operationId\":\"specialDisposalUsingPOST\",\"consumes\":[\"application/json\"],\"produces\":[\"application/json\",\"*/*\"],\"parameters\":[{\"in\":\"body\",\"name\":\"applyItemSpecialDTO\",\"description\":\"applyItemSpecialDTO\",\"required\":true,\"schema\":{\"$ref\":\"#/definitions/ApplyItemSpecialDTO\"}}],\"responses\":{\"200\":{\"description\":\"OK\",\"schema\":{\"$ref\":\"#/definitions/ControllerResult\"}},\"201\":{\"description\":\"Created\"},\"401\":{\"description\":\"Unauthorized\"},\"403\":{\"description\":\"Forbidden\"},\"404\":{\"description\":\"Not Found\"}}}},\"/applyItemAppointment/appointments/{oppointmentId}\":{\"post\":{\"tags\":[\"网上预约\"],\"summary\":\"预约处理\",\"operationId\":\"appointmentHandleUsingPOST\",\"consumes\":[\"application/json\"],\"produces\":[\"application/json\",\"*/*\"],\"parameters\":[{\"name\":\"oppointmentId\",\"in\":\"path\",\"description\":\"预约id\",\"required\":false,\"type\":\"string\"}],\"responses\":{\"200\":{\"description\":\"OK\",\"schema\":{\"$ref\":\"#/definitions/ControllerResult\"}},\"201\":{\"description\":\"Created\"},\"401\":{\"description\":\"Unauthorized\"},\"403\":{\"description\":\"Forbidden\"},\"404\":{\"description\":\"Not Found\"}}},\"delete\":{\"tags\":[\"网上预约\"],\"summary\":\"预约删除\",\"operationId\":\"appointmentDeleteUsingDELETE\",\"consumes\":[\"application/json\"],\"produces\":[\"application/json\",\"*/*\"],\"parameters\":[{\"name\":\"oppointmentId\",\"in\":\"path\",\"description\":\"预约id\",\"required\":false,\"type\":\"string\"}],\"responses\":{\"200\":{\"description\":\"OK\",\"schema\":{\"$ref\":\"#/definitions/ControllerResult\"}},\"401\":{\"description\":\"Unauthorized\"},\"204\":{\"description\":\"No Content\"},\"403\":{\"description\":\"Forbidden\"}}}},\"/applyItemAppointment/enterprise\":{\"post\":{\"tags\":[\"网上预约\"],\"summary\":\"查询企业网上预约信息列表\",\"operationId\":\"selectEnterpriseAppointmentsUsingPOST\",\"consumes\":[\"application/json\"],\"produces\":[\"application/json\",\"*/*\"],\"parameters\":[{\"in\":\"body\",\"name\":\"enterpriseAppointmentQuery\",\"description\":\"enterpriseAppointmentQuery\",\"required\":true,\"schema\":{\"$ref\":\"#/definitions/EnterpriseAppointmentQuery\"}}],\"responses\":{\"200\":{\"description\":\"OK\",\"schema\":{\"$ref\":\"#/definitions/PageResult«EnterpriseAppointmentVO»\"}},\"201\":{\"description\":\"Created\"},\"401\":{\"description\":\"Unauthorized\"},\"403\":{\"description\":\"Forbidden\"},\"404\":{\"description\":\"Not Found\"}}}},\"/applyItemAppointment/invalid/{oppointmentId}\":{\"post\":{\"tags\":[\"网上预约\"],\"summary\":\"预约作废\",\"operationId\":\"appointmentInvalidUsingPOST\",\"consumes\":[\"application/json\"],\"produces\":[\"application/json\",\"*/*\"],\"parameters\":[{\"name\":\"oppointmentId\",\"in\":\"path\",\"description\":\"预约id\",\"required\":false,\"type\":\"string\"},{\"name\":\"invalidReason\",\"in\":\"query\",\"description\":\"预约作废原因\",\"required\":false,\"type\":\"string\"}],\"responses\":{\"200\":{\"description\":\"OK\",\"schema\":{\"$ref\":\"#/definitions/ControllerResult\"}},\"201\":{\"description\":\"Created\"},\"401\":{\"description\":\"Unauthorized\"},\"403\":{\"description\":\"Forbidden\"},\"404\":{\"description\":\"Not Found\"}}}},\"/applyItemAppointment/person\":{\"post\":{\"tags\":[\"网上预约\"],\"summary\":\"查询个人网上预约信息列表\",\"operationId\":\"selectPersonAppointmentsUsingPOST\",\"consumes\":[\"application/json\"],\"produces\":[\"application/json\",\"*/*\"],\"parameters\":[{\"in\":\"body\",\"name\":\"personAppointmentQuery\",\"description\":\"personAppointmentQuery\",\"required\":true,\"schema\":{\"$ref\":\"#/definitions/PersonAppointmentQuery\"}}],\"responses\":{\"200\":{\"description\":\"OK\",\"schema\":{\"$ref\":\"#/definitions/PageResult«PersonAppointmentVO»\"}},\"201\":{\"description\":\"Created\"},\"401\":{\"description\":\"Unauthorized\"},\"403\":{\"description\":\"Forbidden\"},\"404\":{\"description\":\"Not Found\"}}}},\"/applyItemDeal/selectList\":{\"post\":{\"tags\":[\"业务办理\"],\"summary\":\"获取处理列表\",\"operationId\":\"selectListUsingPOST\",\"consumes\":[\"application/json\"],\"produces\":[\"application/json\",\"*/*\"],\"parameters\":[{\"name\":\"itemId\",\"in\":\"query\",\"description\":\"itemId\",\"required\":false,\"type\":\"string\"}],\"responses\":{\"200\":{\"description\":\"OK\",\"schema\":{\"type\":\"array\",\"items\":{\"$ref\":\"#/definitions/ApplyItemDealVO\"}}},\"201\":{\"description\":\"Created\"},\"401\":{\"description\":\"Unauthorized\"},\"403\":{\"description\":\"Forbidden\"},\"404\":{\"description\":\"Not Found\"}}}},\"/applyItemDocumentRelation/getApplyItemDocument\":{\"post\":{\"tags\":[\"申请文书\"],\"summary\":\"获取申请事项文书信息\",\"operationId\":\"getApplyItemDocumentUsingPOST\",\"consumes\":[\"application/json\"],\"produces\":[\"application/json\",\"*/*\"],\"parameters\":[{\"name\":\"applyItemId\",\"in\":\"query\",\"description\":\"applyItemId\",\"required\":false,\"type\":\"string\"}],\"responses\":{\"200\":{\"description\":\"OK\",\"schema\":{\"$ref\":\"#/definitions/ControllerResult\"}},\"201\":{\"description\":\"Created\"},\"401\":{\"description\":\"Unauthorized\"},\"403\":{\"description\":\"Forbidden\"},\"404\":{\"description\":\"Not Found\"}}}},\"/egovAppointmentConfig/batchInsert.do\":{\"post\":{\"tags\":[\"预约配置管理\"],\"summary\":\"批量添加预约配置\",\"operationId\":\"batchInsertUsingPOST_7\",\"consumes\":[\"application/json\"],\"produces\":[\"application/json\",\"*/*\"],\"parameters\":[{\"in\":\"body\",\"name\":\"appointmentList\",\"description\":\"appointmentList\",\"required\":true,\"schema\":{\"type\":\"array\",\"items\":{\"$ref\":\"#/definitions/AppointmentConfig\"}}}],\"responses\":{\"200\":{\"description\":\"OK\",\"schema\":{\"type\":\"object\"}},\"401\":{\"description\":\"Unauthorized\"},\"204\":{\"description\":\"No Content\"},\"403\":{\"description\":\"Forbidden\"}}}},\"/egovAppointmentConfig/batchUpdate.do\":{\"post\":{\"tags\":[\"预约配置管理\"],\"summary\":\"批量更新预约配置\",\"operationId\":\"batchUpdateUsingPOST_7\",\"consumes\":[\"application/json\"],\"produces\":[\"application/json\",\"*/*\"],\"parameters\":[{\"in\":\"body\",\"name\":\"appointmentList\",\"description\":\"appointmentList\",\"required\":true,\"schema\":{\"type\":\"array\",\"items\":{\"$ref\":\"#/definitions/AppointmentConfig\"}}}],\"responses\":{\"200\":{\"description\":\"OK\",\"schema\":{\"type\":\"object\"}},\"401\":{\"description\":\"Unauthorized\"},\"204\":{\"description\":\"No Content\"},\"403\":{\"description\":\"Forbidden\"}}}},\"/egovAppointmentConfig/insert.do\":{\"post\":{\"tags\":[\"预约配置管理\"],\"summary\":\"添加预约配置\",\"operationId\":\"insertUsingPOST_7\",\"consumes\":[\"application/json\"],\"produces\":[\"application/json\",\"*/*\"],\"parameters\":[{\"in\":\"body\",\"name\":\"appointment\",\"description\":\"appointment\",\"required\":true,\"schema\":{\"$ref\":\"#/definitions/AppointmentConfig\"}}],\"responses\":{\"200\":{\"description\":\"OK\",\"schema\":{\"type\":\"object\"}},\"401\":{\"description\":\"Unauthorized\"},\"204\":{\"description\":\"No Content\"},\"403\":{\"description\":\"Forbidden\"}}}},\"/egovAppointmentConfig/list.do\":{\"post\":{\"tags\":[\"预约配置管理\"],\"summary\":\"查询预约配置信息\",\"operationId\":\"listUsingPOST_7\",\"consumes\":[\"application/json\"],\"produces\":[\"application/json\",\"*/*\"],\"parameters\":[{\"in\":\"body\",\"name\":\"appointmentQuery\",\"description\":\"appointmentQuery\",\"required\":true,\"schema\":{\"$ref\":\"#/definitions/预约设置查看类\"}}],\"responses\":{\"200\":{\"description\":\"OK\",\"schema\":{\"type\":\"object\"}},\"401\":{\"description\":\"Unauthorized\"},\"204\":{\"description\":\"No Content\"},\"403\":{\"description\":\"Forbidden\"}}}},\"/egovAppointmentConfig/pageList.do\":{\"post\":{\"tags\":[\"预约配置管理\"],\"summary\":\"查询预约配置信息(分页)\",\"operationId\":\"pageListUsingPOST_7\",\"consumes\":[\"application/json\"],\"produces\":[\"application/json\",\"*/*\"],\"parameters\":[{\"in\":\"body\",\"name\":\"appointmentQuery\",\"description\":\"appointmentQuery\",\"required\":true,\"schema\":{\"$ref\":\"#/definitions/分页条件实体类\"}}],\"responses\":{\"200\":{\"description\":\"OK\",\"schema\":{\"$ref\":\"#/definitions/PageResult«ApplyItemAppointmentConfigVO»\"}},\"401\":{\"description\":\"Unauthorized\"},\"204\":{\"description\":\"No Content\"},\"403\":{\"description\":\"Forbidden\"}}}},\"/egovAppointmentConfig/update.do\":{\"post\":{\"tags\":[\"预约配置管理\"],\"summary\":\"更新预约配置\",\"operationId\":\"updateUsingPOST_7\",\"consumes\":[\"application/json\"],\"produces\":[\"application/json\",\"*/*\"],\"parameters\":[{\"in\":\"body\",\"name\":\"appointment\",\"description\":\"appointment\",\"required\":true,\"schema\":{\"$ref\":\"#/definitions/AppointmentConfig\"}}],\"responses\":{\"200\":{\"description\":\"OK\",\"schema\":{\"type\":\"object\"}},\"401\":{\"description\":\"Unauthorized\"},\"204\":{\"description\":\"No Content\"},\"403\":{\"description\":\"Forbidden\"}}}}},\"definitions\":{\"ApplyItemAppointmentConfigVO\":{\"type\":\"object\",\"properties\":{\"endDate\":{\"type\":\"string\",\"format\":\"date-time\"},\"isConfig\":{\"type\":\"integer\",\"format\":\"int32\"},\"item\":{\"$ref\":\"#/definitions/Item\"},\"startDate\":{\"type\":\"string\",\"format\":\"date-time\"}}},\"ApplyItemSpecialDTO\":{\"type\":\"object\",\"properties\":{\"applyId\":{\"type\":\"string\",\"description\":\"申请人信息\"},\"applyItemsId\":{\"type\":\"string\",\"description\":\"申请事项主键ID\"},\"currentBusinessAction\":{\"type\":\"string\",\"description\":\"特别程序种类\"},\"expectEndDate\":{\"description\":\"预期结束时间\",\"$ref\":\"#/definitions/Timestamp\"},\"processInstanceId\":{\"type\":\"string\",\"description\":\"流程实例ID\"},\"reason\":{\"type\":\"string\",\"description\":\"启动理由\"},\"startDate\":{\"description\":\"开始日期\",\"$ref\":\"#/definitions/Timestamp\"}}},\"EnterpriseApplyItemDTO\":{\"type\":\"object\",\"properties\":{\"acceptUserCode\":{\"type\":\"string\",\"description\":\"受理人编码，数据对接使用\"},\"acceptUserName\":{\"type\":\"string\",\"description\":\"受理人姓名，数据对接使用\"},\"applyItemDescription\":{\"type\":\"string\",\"description\":\"项目描述\"},\"applyItemFileDTOS\":{\"type\":\"array\",\"description\":\"申请事项材料\",\"items\":{\"$ref\":\"#/definitions/ApplyItemFileDTO\"}},\"applyItemName\":{\"type\":\"string\",\"description\":\"项目名称\"},\"applySource\":{\"type\":\"string\",\"description\":\"申请来源\"},\"applyUserAddress\":{\"type\":\"string\",\"description\":\"申请人地址\"},\"applyUserEmail\":{\"type\":\"string\",\"description\":\"申请人邮箱\"},\"applyUserId\":{\"type\":\"string\",\"description\":\"申请用户\"},\"appointmentId\":{\"type\":\"string\",\"description\":\"预约主键\"},\"contactUser\":{\"type\":\"string\",\"description\":\"联系人\"},\"contactUserPhone\":{\"type\":\"string\",\"description\":\"联系人电话\"},\"id\":{\"type\":\"string\",\"description\":\"事项申请id，数据对接使用\"},\"itemId\":{\"type\":\"string\",\"description\":\"事项主键ID\"},\"receiveNum\":{\"type\":\"string\",\"description\":\"省一窗系统事项申请编码\"}}},\"Timestamp\":{\"type\":\"object\",\"properties\":{\"date\":{\"type\":\"integer\",\"format\":\"int32\"},\"day\":{\"type\":\"integer\",\"format\":\"int32\"},\"hours\":{\"type\":\"integer\",\"format\":\"int32\"},\"minutes\":{\"type\":\"integer\",\"format\":\"int32\"},\"month\":{\"type\":\"integer\",\"format\":\"int32\"},\"nanos\":{\"type\":\"integer\",\"format\":\"int32\"},\"seconds\":{\"type\":\"integer\",\"format\":\"int32\"},\"time\":{\"type\":\"integer\",\"format\":\"int64\"},\"timezoneOffset\":{\"type\":\"integer\",\"format\":\"int32\"},\"year\":{\"type\":\"integer\",\"format\":\"int32\"}}},\"EnterpriseAppointmentVO\":{\"type\":\"object\",\"properties\":{\"appointmentDate\":{\"description\":\"办理日期\",\"$ref\":\"#/definitions/Timestamp\"},\"appointmentPeriod\":{\"type\":\"string\",\"description\":\"办理时段\"},\"appointmentStatus\":{\"type\":\"string\",\"description\":\"状态\"},\"contactUser\":{\"type\":\"string\",\"description\":\"联系人\"},\"createDate\":{\"description\":\"预约时间\",\"$ref\":\"#/definitions/Timestamp\"},\"email\":{\"type\":\"string\",\"description\":\"邮箱\"},\"enterpriseName\":{\"type\":\"string\",\"description\":\"企业名称\"},\"id\":{\"type\":\"string\"},\"invalidReson\":{\"type\":\"string\"},\"itemId\":{\"type\":\"string\",\"description\":\"预约事项id\"},\"itemName\":{\"type\":\"string\",\"description\":\"预约事项\"},\"mobilePhone\":{\"type\":\"string\",\"description\":\"联系电话\"},\"userId\":{\"type\":\"string\",\"description\":\"用户ID\"}}},\"Item\":{\"type\":\"object\",\"properties\":{\"acceptInformation\":{\"type\":\"string\"},\"acceptPeriod\":{\"type\":\"string\"},\"adminObligation\":{\"type\":\"string\"},\"adminRight\":{\"type\":\"string\"},\"admissibility\":{\"type\":\"string\"},\"agencyBasis\":{\"type\":\"string\"},\"agencyQualifications\":{\"type\":\"string\"},\"applyInformation\":{\"type\":\"string\"},\"applyTimeLimit\":{\"type\":\"string\"},\"authority\":{\"type\":\"string\"},\"chargeBasis\":{\"type\":\"string\"},\"chargeContent\":{\"type\":\"string\"},\"chargeDerate\":{\"type\":\"string\"},\"chargeEntryname\":{\"type\":\"string\"},\"chargeStandard\":{\"type\":\"string\"},\"checkPoint\":{\"type\":\"string\"},\"code\":{\"type\":\"string\"},\"commonProblem\":{\"type\":\"string\"},\"communicationAddress\":{\"type\":\"string\"},\"complaintsPostalcode\":{\"type\":\"string\"},\"consultWay\":{\"type\":\"string\"},\"content\":{\"type\":\"string\"},\"createDate\":{\"$ref\":\"#/definitions/Timestamp\"},\"dutyDepartment\":{\"type\":\"string\"},\"executeResult\":{\"type\":\"string\"},\"exerciseLevel\":{\"type\":\"string\"},\"exerciseType\":{\"type\":\"string\"},\"flowChartUrl\":{\"type\":\"string\"},\"handlingForm\":{\"type\":\"string\"},\"handlingPlace\":{\"type\":\"string\"},\"handlingTime\":{\"type\":\"string\",\"format\":\"date-time\"},\"id\":{\"type\":\"string\"},\"implementCode\":{\"type\":\"string\"},\"implementOrg\":{\"type\":\"string\"},\"inspectComplain\":{\"type\":\"string\"},\"invalidContent\":{\"type\":\"string\"},\"invalidFlag\":{\"type\":\"string\"},\"isDeal\":{\"type\":\"string\"},\"isOnsiteHandling\":{\"type\":\"string\"},\"ischarge\":{\"type\":\"string\"},\"itemType\":{\"type\":\"string\"},\"letterComplainOrg\":{\"type\":\"string\"},\"logisticsExpress\":{\"type\":\"string\"},\"material\":{\"type\":\"string\"},\"materialStandard\":{\"type\":\"string\"},\"name\":{\"type\":\"string\"},\"nameVerified\":{\"type\":\"string\"},\"numberLimit\":{\"type\":\"string\"},\"officeId\":{\"type\":\"string\"},\"operationScope\":{\"type\":\"string\"},\"parentId\":{\"type\":\"string\"},\"paymentOnline\":{\"type\":\"string\"},\"processIntanceKey\":{\"type\":\"string\"},\"processQuery\":{\"type\":\"string\"},\"promiseTimeLimit\":{\"type\":\"string\"},\"redirectUrl\":{\"type\":\"string\"},\"remarks\":{\"type\":\"string\"},\"reservation\":{\"type\":\"string\"},\"result\":{\"type\":\"string\"},\"resultSample\":{\"type\":\"string\"},\"runningSystem\":{\"type\":\"string\"},\"sendWay\":{\"type\":\"string\"},\"serviceObject\":{\"type\":\"string\"},\"setBasis\":{\"type\":\"string\"},\"sort\":{\"type\":\"number\",\"format\":\"double\"},\"specialPeocedure\":{\"type\":\"string\"},\"subjectProperty\":{\"type\":\"string\"},\"superviseTelephone\":{\"type\":\"string\"},\"telephone\":{\"type\":\"string\"},\"timeLimit\":{\"type\":\"string\"},\"type\":{\"type\":\"string\"},\"unionOrg\":{\"type\":\"string\"},\"updateDate\":{\"$ref\":\"#/definitions/Timestamp\"},\"windowNumber\":{\"type\":\"string\"}}},\"ControllerResult\":{\"type\":\"object\",\"properties\":{\"data\":{\"type\":\"object\"},\"message\":{\"type\":\"string\"},\"status\":{\"type\":\"boolean\"}}},\"PersonAppointmentVO\":{\"type\":\"object\",\"properties\":{\"appointmentDate\":{\"description\":\"办理日期\",\"$ref\":\"#/definitions/Timestamp\"},\"appointmentPeriod\":{\"type\":\"string\",\"description\":\"办理时段\"},\"appointmentStatus\":{\"type\":\"string\",\"description\":\"状态\"},\"createDate\":{\"description\":\"预约时间\",\"$ref\":\"#/definitions/Timestamp\"},\"email\":{\"type\":\"string\",\"description\":\"邮箱\"},\"id\":{\"type\":\"string\"},\"invalidReson\":{\"type\":\"string\"},\"itemId\":{\"type\":\"string\",\"description\":\"预约事项id\"},\"itemName\":{\"type\":\"string\",\"description\":\"预约事项\"},\"mobilePhone\":{\"type\":\"string\",\"description\":\"联系电话\"},\"userId\":{\"type\":\"string\",\"description\":\"用户ID\"},\"userName\":{\"type\":\"string\",\"description\":\"预约人姓名\"}}},\"PersonApplyItemDTO\":{\"type\":\"object\",\"properties\":{\"acceptUserCode\":{\"type\":\"string\",\"description\":\"受理人编码，数据对接使用\"},\"acceptUserName\":{\"type\":\"string\",\"description\":\"受理人姓名，数据对接使用\"},\"applyItemDescription\":{\"type\":\"string\",\"description\":\"项目描述\"},\"applyItemFileDTOS\":{\"type\":\"array\",\"description\":\"申请事项材料\",\"items\":{\"$ref\":\"#/definitions/ApplyItemFileDTO\"}},\"applyItemName\":{\"type\":\"string\",\"description\":\"项目名称\"},\"applySource\":{\"type\":\"string\",\"description\":\"申请来源\"},\"applyUserAddress\":{\"type\":\"string\",\"description\":\"申请人地址\"},\"applyUserEmail\":{\"type\":\"string\",\"description\":\"申请人邮箱\"},\"applyUserId\":{\"type\":\"string\",\"description\":\"申请用户\"},\"appointmentId\":{\"type\":\"string\",\"description\":\"预约主键\"},\"id\":{\"type\":\"string\",\"description\":\"事项申请id，数据对接使用\"},\"itemId\":{\"type\":\"string\",\"description\":\"事项主键ID\"},\"receiveNum\":{\"type\":\"string\",\"description\":\"省一窗系统事项申请编码\"}}},\"ApplyItemQuery\":{\"type\":\"object\",\"properties\":{\"applyDateEnd\":{\"type\":\"string\",\"description\":\"申请时间\"},\"applyDateStart\":{\"type\":\"string\",\"description\":\"申请时间\"},\"applyItemName\":{\"type\":\"string\",\"description\":\"项目名称\"},\"businessAction\":{\"type\":\"string\",\"description\":\"业务动作\"},\"current\":{\"type\":\"integer\",\"format\":\"int32\",\"example\":1,\"description\":\"当前页码\"},\"processIntenceIds\":{\"type\":\"array\",\"description\":\"流程Id，用于待办事项查询，在页面无需处理操作\",\"items\":{\"type\":\"string\"}},\"size\":{\"type\":\"integer\",\"format\":\"int32\",\"example\":10,\"description\":\"每页显示条数\"},\"status\":{\"type\":\"string\",\"description\":\"办理状态\"},\"userType\":{\"type\":\"string\",\"description\":\"用户类型\"}}},\"ApplyItemDetailVO\":{\"type\":\"object\",\"properties\":{\"acceptUserCode\":{\"type\":\"string\",\"description\":\"受理人编码\"},\"acceptUserName\":{\"type\":\"string\",\"description\":\"受理人姓名\"},\"applyItemApplyDate\":{\"description\":\"事项申请时间\",\"$ref\":\"#/definitions/Timestamp\"},\"applyItemDescription\":{\"type\":\"string\",\"description\":\"项目描述\"},\"applyItemFiles\":{\"type\":\"array\",\"description\":\"已提交材料\",\"items\":{\"$ref\":\"#/definitions/ApplyItemFile\"}},\"applyItemName\":{\"type\":\"string\",\"description\":\"项目名称\"},\"applyUserAddress\":{\"type\":\"string\",\"description\":\"联系地址\"},\"applyUserEmail\":{\"type\":\"string\",\"description\":\"邮箱\"},\"code\":{\"type\":\"string\",\"description\":\"申请事项办件编号\"},\"contactUser\":{\"type\":\"string\",\"description\":\"联系人姓名\"},\"contactUserPhone\":{\"type\":\"string\",\"description\":\"联系人电话\"},\"itemName\":{\"type\":\"string\",\"description\":\"事项名称\"},\"noRight\":{\"type\":\"boolean\",\"example\":false,\"description\":\"是否无权处理：true-无权处理；false-有权处理\"},\"statusLabel\":{\"type\":\"string\",\"description\":\"申请事项状态label\"},\"statusValue\":{\"type\":\"string\",\"description\":\"申请事项状态value\"},\"unSubmittedApplyItemFiles\":{\"type\":\"array\",\"description\":\"未提交材料\",\"items\":{\"$ref\":\"#/definitions/Map«string,string»\"}},\"userType\":{\"type\":\"string\",\"description\":\"用户类型：0-个人；1-法人\"}}},\"PageResult«PersonAppointmentVO»\":{\"type\":\"object\",\"properties\":{\"current\":{\"type\":\"integer\",\"format\":\"int32\"},\"data\":{\"type\":\"object\"},\"pages\":{\"type\":\"integer\",\"format\":\"int64\"},\"records\":{\"type\":\"array\",\"items\":{\"$ref\":\"#/definitions/PersonAppointmentVO\"}},\"size\":{\"type\":\"integer\",\"format\":\"int32\"},\"total\":{\"type\":\"integer\",\"format\":\"int64\"}}},\"PageResult«EnterpriseAppointmentVO»\":{\"type\":\"object\",\"properties\":{\"current\":{\"type\":\"integer\",\"format\":\"int32\"},\"data\":{\"type\":\"object\"},\"pages\":{\"type\":\"integer\",\"format\":\"int64\"},\"records\":{\"type\":\"array\",\"items\":{\"$ref\":\"#/definitions/EnterpriseAppointmentVO\"}},\"size\":{\"type\":\"integer\",\"format\":\"int32\"},\"total\":{\"type\":\"integer\",\"format\":\"int64\"}}},\"预约设置查看类\":{\"type\":\"object\",\"properties\":{\"endDate\":{\"type\":\"string\",\"format\":\"date-time\",\"description\":\"结束时间\"},\"itemID\":{\"type\":\"string\",\"description\":\"事项Id\"},\"orgID\":{\"type\":\"string\",\"description\":\"所在机构Id\"},\"startDate\":{\"type\":\"string\",\"format\":\"date-time\",\"description\":\"开始时间\"}}},\"PageResult«ApplyItemAppointmentConfigVO»\":{\"type\":\"object\",\"properties\":{\"current\":{\"type\":\"integer\",\"format\":\"int32\"},\"data\":{\"type\":\"object\"},\"pages\":{\"type\":\"integer\",\"format\":\"int64\"},\"records\":{\"type\":\"array\",\"items\":{\"$ref\":\"#/definitions/ApplyItemAppointmentConfigVO\"}},\"size\":{\"type\":\"integer\",\"format\":\"int32\"},\"total\":{\"type\":\"integer\",\"format\":\"int64\"}}},\"ApplyItemVO\":{\"type\":\"object\",\"properties\":{\"applyDate\":{\"$ref\":\"#/definitions/Timestamp\"},\"applyItemName\":{\"type\":\"string\"},\"applySource\":{\"type\":\"string\"},\"businessAction\":{\"type\":\"string\"},\"bussnessActionLabel\":{\"type\":\"string\"},\"bussnessActionValue\":{\"type\":\"string\"},\"code\":{\"type\":\"string\"},\"contactUser\":{\"type\":\"string\"},\"id\":{\"type\":\"string\"},\"itemName\":{\"type\":\"string\"},\"legalName\":{\"type\":\"string\"},\"mobilePhone\":{\"type\":\"string\"},\"name\":{\"type\":\"string\"},\"timeOut\":{\"$ref\":\"#/definitions/ApplyItemActivitiTimeDTO\"}}},\"ApplyItemActivitiTimeDTO\":{\"type\":\"object\",\"properties\":{\"day\":{\"type\":\"integer\",\"format\":\"int32\"},\"description\":{\"type\":\"string\"},\"processId\":{\"type\":\"string\"},\"taskName\":{\"type\":\"string\"},\"timeOut\":{\"type\":\"string\"}}},\"EnterpriseAppointmentQuery\":{\"type\":\"object\",\"properties\":{\"appointmentDateEnd\":{\"type\":\"string\",\"format\":\"date-time\",\"description\":\"办理日期\"},\"appointmentDateStart\":{\"type\":\"string\",\"format\":\"date-time\",\"description\":\"办理日期\"},\"appointmentStatus\":{\"type\":\"string\",\"description\":\"预约状态\"},\"current\":{\"type\":\"integer\",\"format\":\"int32\",\"example\":1,\"description\":\"当前页码\"},\"enterpriseName\":{\"type\":\"string\",\"description\":\"预约人姓名\"},\"itemName\":{\"type\":\"string\",\"description\":\"预约事项\"},\"size\":{\"type\":\"integer\",\"format\":\"int32\",\"example\":10,\"description\":\"每页显示条数\"}}},\"ControllerResult«ApplyItemDetailVO»\":{\"type\":\"object\",\"properties\":{\"data\":{\"type\":\"object\"},\"message\":{\"type\":\"string\"},\"status\":{\"type\":\"boolean\"}}},\"AppointmentConfig\":{\"type\":\"object\",\"properties\":{\"actualNumber\":{\"type\":\"number\",\"format\":\"double\"},\"amEndtime\":{\"type\":\"string\"},\"amStarttime\":{\"type\":\"string\"},\"appoDate\":{\"$ref\":\"#/definitions/Timestamp\"},\"appoNumber\":{\"type\":\"number\",\"format\":\"double\"},\"createDate\":{\"$ref\":\"#/definitions/Timestamp\"},\"id\":{\"type\":\"string\"},\"itemId\":{\"type\":\"string\"},\"orgId\":{\"type\":\"string\"},\"pmEndtime\":{\"type\":\"string\"},\"pmStarttime\":{\"type\":\"string\"},\"remarks\":{\"type\":\"string\"},\"updateDate\":{\"$ref\":\"#/definitions/Timestamp\"}}},\"ApplyItemFileDTO\":{\"type\":\"object\",\"properties\":{\"collectMode\":{\"type\":\"string\",\"description\":\"收取方式\"},\"fileName\":{\"type\":\"string\",\"description\":\"文件名称\"},\"name\":{\"type\":\"string\",\"description\":\"材料名称\"},\"url\":{\"type\":\"string\",\"description\":\"url\"}}},\"PageResult«ApplyItemVO»\":{\"type\":\"object\",\"properties\":{\"current\":{\"type\":\"integer\",\"format\":\"int32\"},\"data\":{\"type\":\"object\"},\"pages\":{\"type\":\"integer\",\"format\":\"int64\"},\"records\":{\"type\":\"array\",\"items\":{\"$ref\":\"#/definitions/ApplyItemVO\"}},\"size\":{\"type\":\"integer\",\"format\":\"int32\"},\"total\":{\"type\":\"integer\",\"format\":\"int64\"}}},\"Map«string,string»\":{\"type\":\"object\",\"additionalProperties\":{\"type\":\"string\"}},\"PersonAppointmentQuery\":{\"type\":\"object\",\"properties\":{\"appointmentDateEnd\":{\"type\":\"string\",\"format\":\"date-time\",\"description\":\"办理日期\"},\"appointmentDateStart\":{\"type\":\"string\",\"format\":\"date-time\",\"description\":\"办理日期\"},\"appointmentStatus\":{\"type\":\"string\",\"description\":\"状态\"},\"current\":{\"type\":\"integer\",\"format\":\"int32\",\"example\":1,\"description\":\"当前页码\"},\"itemName\":{\"type\":\"string\",\"description\":\"预约事项\"},\"size\":{\"type\":\"integer\",\"format\":\"int32\",\"example\":10,\"description\":\"每页显示条数\"},\"userName\":{\"type\":\"string\",\"description\":\"预约人姓名\"}}},\"ApplyItemDealVO\":{\"type\":\"object\",\"properties\":{\"approvOrg\":{\"type\":\"string\"},\"approveName\":{\"type\":\"string\"},\"approveOpinion\":{\"type\":\"string\"},\"approveStatus\":{\"type\":\"integer\",\"format\":\"int32\"},\"businessAction\":{\"type\":\"string\"},\"endDate\":{\"type\":\"string\",\"format\":\"date-time\"},\"processId\":{\"type\":\"string\"},\"sort\":{\"type\":\"number\",\"format\":\"double\"},\"startDate\":{\"type\":\"string\",\"format\":\"date-time\"},\"status\":{\"type\":\"string\"}}},\"分页条件实体类\":{\"type\":\"object\",\"properties\":{\"current\":{\"type\":\"integer\",\"format\":\"int32\",\"example\":1,\"description\":\"当前页码\"},\"endDate\":{\"type\":\"string\",\"format\":\"date-time\",\"description\":\"结束时间\"},\"itemID\":{\"type\":\"string\",\"description\":\"事项Id\"},\"name\":{\"type\":\"string\",\"description\":\"事项名称\"},\"orgID\":{\"type\":\"string\",\"description\":\"所在机构Id\"},\"size\":{\"type\":\"integer\",\"format\":\"int32\",\"example\":10,\"description\":\"每页显示条数\"},\"startDate\":{\"type\":\"string\",\"format\":\"date-time\",\"description\":\"开始时间\"}}},\"ApplyItemFile\":{\"type\":\"object\",\"properties\":{\"collectDate\":{\"type\":\"string\",\"format\":\"date-time\"},\"collectMode\":{\"type\":\"string\"},\"collectNumber\":{\"type\":\"number\",\"format\":\"double\"},\"collected\":{\"type\":\"string\"},\"createDate\":{\"$ref\":\"#/definitions/Timestamp\"},\"fileName\":{\"type\":\"string\"},\"id\":{\"type\":\"string\"},\"name\":{\"type\":\"string\"},\"remarks\":{\"type\":\"string\"},\"sort\":{\"type\":\"number\",\"format\":\"double\"},\"updateDate\":{\"$ref\":\"#/definitions/Timestamp\"},\"url\":{\"type\":\"string\"}}}}}";

        Swagger2MarkupConverter.from(s).withConfig(config)
                .build()
                .toFile(Paths.get("./docs/all"));

        /*Swagger2MarkupConverter.from(new URL("http://172.16.3.128:9004/science/v2/api-docs"))
                .withConfig(config)
                .build()
                .toFile(Paths.get("./docs/all"));*/
    }


    @Test
    public void contextLoads() {

    }


    @Test
    public void dbmonitor() {

        String URL="jdbc:mysql://127.0.0.1:3306/imooc?useUnicode=true&amp;characterEncoding=utf-8";
        String USER="root";
        String PASSWORD="tiger";

        Statement st = null;
        ResultSet rs = null;
        Connection conn = null;

        //1.加载驱动程序
        try {
            Class.forName("com.mysql.jdbc.Driver");

            //2.获得数据库链接
            conn= DriverManager.getConnection(URL, USER, PASSWORD);
            //3.通过数据库的连接操作数据库，实现增删改查（使用Statement类）
            st=conn.createStatement();
            rs=st.executeQuery("select * from user");
            //4.处理数据库的返回结果(使用ResultSet类)
            while(rs.next()){
                System.out.println(rs.getString("user_name")+" "+rs.getString("user_password"));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //关闭资源
        try {
            rs.close();
            st.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    /**
     * 一个非常标准的连接Oracle数据库的示例代码
     */
    @Test
    public void testOracle()
    {
        Connection con = null;// 创建一个数据库连接
        PreparedStatement pre = null;// 创建预编译语句对象，一般都是用这个而不用Statement
        ResultSet result = null;// 创建一个结果集对象
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");

            System.out.println("开始尝试连接数据库！");
            String url = "jdbc:oracle:" + "thin:@127.0.0.1:1521:XE";
            String user = "system";
            String password = "147";
            // 获取连接
            con = DriverManager.getConnection(url, user, password);

            String sql = "select * from student where name=?";
            pre = con.prepareStatement(sql);// 实例化预编译语句
            pre.setString(1, "刘显安");
            result = pre.executeQuery();// 执行查询，注意括号中不需要再加参数

            while (result.next())
                // 当结果集不为空时
                System.out.println("学号:" + result.getInt("id") + "姓名:"
                        + result.getString("name"));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                // 逐一将上面的几个对象关闭，因为不关闭的话会影响性能、并且占用资源
                // 注意关闭的顺序，最后使用的最先关闭
                if (result != null)
                    result.close();
                if (pre != null)
                    pre.close();
                if (con != null)
                    con.close();
                System.out.println("数据库连接已关闭！");
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void testSqlServer() {
        // 连接驱动
        String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        // 连接路径
        String URL = "jdbc:sqlserver://localhost:1433;databaseName=DLJC";
        // 用户名
        String USERNAME = "sa";
        // 密码
        String PASSWORD = "root";

        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement ps = null;

        try {
            Class.forName(DRIVER);

            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            String sql = "select * from sys.tables";

            ps = conn.prepareStatement(sql);

            rs = ps.executeQuery();

            while (rs.next()) {
                String name = rs.getString("name");
                System.out.println("====>" + name);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            rs.close();
            conn.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
