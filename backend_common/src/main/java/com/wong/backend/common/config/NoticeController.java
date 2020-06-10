package com.wong.backend.common.config;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/notices")

@Api(tags = "公告相关接口", description = "公告相关接口")
public class NoticeController {
    /**
     * 查询最新的一条公告
     *
     * @return 公告列表
     */
    @GetMapping("/newest")
    @ApiOperation(value = "查询最新的一条公告", notes = "用于：公告")
    public Notice findNewest() {
        return new Notice();
    }
}



