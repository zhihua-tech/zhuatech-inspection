/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.inspection.service;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
class CapaClosureGovernanceServiceTest {
    private final CapaClosureGovernanceService service = new CapaClosureGovernanceService();
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    @Test void closesFullyVerifiedCapa() {
        var result = service.evaluate(new CapaClosureGovernanceService.Request(
                "CAPA-001", true, true, true, true, 0, false));
        assertEquals("CLOSE", result.decision());
        assertEquals(100, result.closureReadiness());
        assertTrue(result.closureAllowed());
    }
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    @Test void reopensCapaWhenIssueRecurs() {
        var result = service.evaluate(new CapaClosureGovernanceService.Request(
                "CAPA-002", true, true, true, false, 1, true));
        assertEquals("REOPEN", result.decision());
        assertEquals(3, result.gaps().size());
        assertFalse(result.closureAllowed());
    }
}
