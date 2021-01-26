package com.dong.system.service.impl;

import com.dong.system.entity.Task;
import com.dong.system.mapper.TaskMapper;
import com.dong.system.service.ITaskService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 */
@Service
public class TaskServiceImpl extends ServiceImpl<TaskMapper, Task> implements ITaskService {

}
