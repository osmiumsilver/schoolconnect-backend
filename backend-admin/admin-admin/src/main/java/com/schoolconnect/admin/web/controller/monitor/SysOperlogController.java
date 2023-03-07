package com.schoolconnect.admin.web.controller.monitor;

import com.schoolconnect.common.annotation.Log;
import com.schoolconnect.common.core.controller.BaseController;
import com.schoolconnect.common.core.domain.AjaxResult;
import com.schoolconnect.common.core.page.TableDataInfo;
import com.schoolconnect.common.enums.BusinessType;
import com.schoolconnect.common.utils.poi.ExcelUtil;
import com.schoolconnect.system.domain.SysOperationLog;
import com.schoolconnect.system.service.ISysOperLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 操作日志记录
 */
@RestController
@RequestMapping("/monitor/operlog")
public class SysOperlogController extends BaseController {
    @Autowired
    private ISysOperLogService operLogService;

    @PreAuthorize("@ss.hasPermi('monitor:operlog:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysOperationLog operLog) {
        startPage();
        List<SysOperationLog> list = operLogService.selectOperLogList(operLog);
        return getDataTable(list);
    }

    @Log(title = "操作日志", businessType = BusinessType.EXPORT)
    @PreAuthorize("@ss.hasPermi('monitor:operlog:export')")
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysOperationLog operLog) {
        List<SysOperationLog> list = operLogService.selectOperLogList(operLog);
        ExcelUtil<SysOperationLog> util = new ExcelUtil<SysOperationLog>(SysOperationLog.class);
        util.exportExcel(response, list, "操作日志");
    }

    @Log(title = "操作日志", businessType = BusinessType.DELETE)
    @PreAuthorize("@ss.hasPermi('monitor:operlog:remove')")
    @DeleteMapping("/{operIds}")
    public AjaxResult remove(@PathVariable Long[] operIds) {
        return toAjax(operLogService.deleteOperLogByIds(operIds));
    }

    @Log(title = "操作日志", businessType = BusinessType.CLEAN)
    @PreAuthorize("@ss.hasPermi('monitor:operlog:remove')")
    @DeleteMapping("/clean")
    public AjaxResult clean() {
        operLogService.cleanOperLog();
        return success();
    }
}
