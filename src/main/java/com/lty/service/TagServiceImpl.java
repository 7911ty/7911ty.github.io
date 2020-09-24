package com.lty.service;

import com.lty.NotFoundException;
import com.lty.dao.TagsRepository;
import com.lty.po.Tag;
import com.lty.po.Type;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagsRepository tagsRepository;

    @Transactional
    @Override
    public Tag saveTag(Tag tag) {
        return tagsRepository.save(tag);
    }

    @Transactional
    @Override
    public Tag getTag(Long id) {

        return tagsRepository.findById(id).get();
    }

    @Transactional
    @Override
    public Page<Tag> listTag(Pageable pageable) {
        return tagsRepository.findAll(pageable);
    }

    @Override
    public List<Tag> listTag() {
        return tagsRepository.findAll();
    }

    @Override
    public List<Tag> listTag(String ids) {
        return tagsRepository.findAllById(convertToList(ids));
    }

    @Override
    public List<Tag> listTagTop(Integer size) {
        /* Sort sort = new Sort(Sort.Direction.DESC,"blogs.size");*/
        Sort sort = Sort.by(Sort.Direction.DESC,"blogs.size");
        /*Pageable pageable = new PageRequest(0,size,sort);*/
        Pageable pageable = PageRequest.of(0,size,sort);
        return tagsRepository.findTop(pageable);

    }

    /*把字符串转换为数组*/
    private  List<Long> convertToList(String ids){
        List<Long> list = new ArrayList<>();
        if (!"".equals(ids) && ids!=null ) {
        String[] idarray = ids.split(  ",");
        for (int i=0; i< idarray.length;i++) {
            list.add(new Long(idarray[i]));
             }
        }
            return list;
    }


    @Transactional
    @Override
    public Tag updateTag(Long id, Tag tag) {
        Tag tag1 = tagsRepository.findById(id).get();
        if (tag1 == null){
            throw new NotFoundException("不存在该标签");
        }
        BeanUtils.copyProperties(tag,tag1);
        return tagsRepository.save(tag1);
    }

    @Transactional
    @Override
    public void deleteTag(Long id) {
        tagsRepository.deleteById(id);
    }

    @Transactional
    @Override
    public Tag getTagByName(String name) {

        return tagsRepository.findByName(name);
    }
}
