# Simple Multi-Paging - JAVA

## Contributors:
---
Author: Masood Ahmed <br>
Email: masood20@connect.hku.hk<br>

---

## Description:

This repository contains a JAVA program that finds statistics for simple Multi-Paging scenarios in Operating Systems.

## Background:

Paging is a method of gaining access to data more quickly. When a program requires a page, it is
available in the main memory because the OS copies a set number of pages from the storage device into
the main memory. Paging permits a process’s physical address space to be non-contiguous. Paging
refers to a memory management strategy that does away with the need for the allocation of contiguous
physical memory.

## What is Paging in the OS?

Paging is a storage mechanism used in OS to retrieve processes from secondary storage to the main
memory as pages. The primary concept behind paging is to break each process into individual pages.
Thus the primary memory would also be separated into frames.

One page of the process must be saved in one of the given memory frames. These pages can be stored
in various memory locations, but finding contiguous frames/holes is always the main goal. Process pages
are usually only brought into the main memory when they are needed; else, they are stored in
secondary storage.

The frame sizes may vary depending on the OS. Each frame must be of the same size. Since the pages
present in paging are mapped onto the frames, the page size should be similar to the frame size.

## Contributing

If you find a bug or want to suggest an improvement, please open an issue or submit a pull request.

*Thank you for reading. Stay happy and stay safe :)*