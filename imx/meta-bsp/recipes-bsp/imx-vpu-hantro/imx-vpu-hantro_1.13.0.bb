# Copyright 2017-2018 NXP

require imx-vpu-hantro.inc
LIC_FILES_CHKSUM = "file://COPYING;md5=72c0f70181bb6e83eee6aab8de12a9f3"

SRC_URI[md5sum] = "48593116d410ed152d63a9a0ae35524f"
SRC_URI[sha256sum] = "e4bff5ee4c68233428dda4ff33ab890010429fa4d4c7acee43dbdf2600f99018"


SRC_URI += "file://0001-MMIOT-193-Use-hantro-driver-to-read-VPU-io-regs.patch;md5sum=d5b99db333214e9d44ee338a50d37692" 
SRC_URI += "file://0002-MMIOT-91-Fix-memory-leak-in-VP9-hwd-decoder.patch;md5sum=ce22e5bf9986fed601ed3f12878e9ed4" 
SRC_URI += "file://0003-MMIOT-91-Fix-memory-leak-in-VP9-hwd-decoder.patch;md5sum=8a6575a0bb397d8fbb71f98d6fc4672b" 
SRC_URI += "file://0004-M865SW-132-G1G2-HEVC-decoder-illegal-memory-access-i.patch;md5sum=d7565b9229c6beacc5e10197460fa6af" 
SRC_URI += "file://0005-MMIOT-418-Allow-to-configure-CFG_SECURE_DATA_PATH-on.patch;md5sum=3e99cbecbf06bb81b335f51780ae8265" 
SRC_URI += "file://0006-MMIOT-477-Parse-VP9-super-frame-index-in-secure-mode.patch;md5sum=170511e9c5b8251939c779fcd4ba17ba" 
SRC_URI += "file://0007-MMIOT-486-Apply-VSI-Patch-remove-secure-memory-acces.patch;md5sum=81ba9036e7943f6e085c27d876a5e15e" 
SRC_URI += "file://0008-MMIOT-487-Checking-in-the-fix-for-the-VPU-Decode-Iss.patch;md5sum=43d2d171b12c1e4e4ac227ddcfe823b0" 
SRC_URI += "file://0009-MMIOT-578-integrate-h264-and-hevc-NAL-parsing-patche.patch;md5sum=06a865874f80e6d32fb0b29f74436a40" 

COMPATIBLE_MACHINE = "imxvpuhantro"
